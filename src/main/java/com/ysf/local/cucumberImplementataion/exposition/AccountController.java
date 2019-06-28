package com.ysf.local.cucumberImplementataion.exposition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysf.local.cucumberImplementataion.application.AccountService;
import com.ysf.local.cucumberImplementataion.common.AccountException;
import com.ysf.local.cucumberImplementataion.domaine.Account;

@RestController
@RequestMapping("/account")
@CrossOrigin(value="*")
public class AccountController {

	@Autowired
	private AccountService accountService;
	private List<Account> accounts; 
	private Account account;
	
	@GetMapping()
	public List<Account> getAllAccounts(){
		accounts = accountService.accounts();
		return accounts;
	}
	
	@PostMapping()
	public Account createAccount(@RequestBody Account account) throws AccountException {
		account =  accountService.createAccount(account);
		return account;
	}
	@GetMapping("/{accountId}")
	public Account getAccount(@PathVariable(name="accountId") Long accountId) throws AccountException {
		account =  accountService.getAccount(accountId);
		return account;
	}
	
	@PutMapping("/credit/{id}/{balance}")
	public Account credit(@PathVariable Long id , @PathVariable Double balance)  throws AccountException{
		account =  accountService.credit(id, balance);
		return account;
	}
	
	@PutMapping("/debit/{id}/{balance}")
	public Account debit(@PathVariable Long id ,@PathVariable Double balance)  throws AccountException{
		account =  accountService.debit(id, balance);
		return account;
	}
	
	@DeleteMapping("/{id}")
	public List<Account> debit(@PathVariable Long id )  throws AccountException{
		 accountService.delete(id);
		return  accountService.accounts();
	}
	
	
	
}
