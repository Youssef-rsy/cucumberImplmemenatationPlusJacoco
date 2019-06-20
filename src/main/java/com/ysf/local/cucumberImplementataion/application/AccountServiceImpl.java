package com.ysf.local.cucumberImplementataion.application;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysf.local.cucumberImplementataion.common.AccountException;
import com.ysf.local.cucumberImplementataion.domaine.Account;
import com.ysf.local.cucumberImplementataion.infrastricture.AccountsRepository;

@Transactional
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountsRepository repos;
	
	private Account account; 
	
	@Override
	public Account createAccount(Account account) throws AccountException {
		account =  repos.save(account);
		if(null==account)
				throw new AccountException("error creating account ");
		return account;
	}

	@Override
	public List<Account> accounts() {
		List<Account> accounts =  repos.findAll();
		return accounts;
	}

	@Override
	public Account getAccount(Long accountId) throws AccountException  {
		account =  repos.findById(accountId).orElseThrow(AccountException::new);
		return account;
	}

	@Override
	public Account credit(Long accountId, Double balance) throws AccountException {
		account =  getAccount(accountId);
		account.setBalance(account.getBalance()+balance);
		
		return null;
	}

	@Override
	public Account debit(Long accountId, Double balance) throws AccountException{
		account =  getAccount(accountId);
		double accountBalance = account.getBalance()-balance;
		if (accountBalance>=0)
			account.setBalance(accountBalance);
		else
			throw new AccountException("unsatisfactory balance to perform this operation");
		
		account = repos.save(account);
		return account;
	}

}
