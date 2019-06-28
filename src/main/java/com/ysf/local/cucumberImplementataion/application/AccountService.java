package com.ysf.local.cucumberImplementataion.application;

import java.util.List;

import com.ysf.local.cucumberImplementataion.common.AccountException;
import com.ysf.local.cucumberImplementataion.domaine.Account;

public interface AccountService {
	
	public Account createAccount(Account account) throws AccountException;
	public List<Account> accounts();
	public Account getAccount(Long accountId) throws AccountException;
	public Account credit(Long id , Double balance) throws AccountException;
	public Account debit(Long id , Double balance) throws AccountException;
	public void delete(Long id);

}
