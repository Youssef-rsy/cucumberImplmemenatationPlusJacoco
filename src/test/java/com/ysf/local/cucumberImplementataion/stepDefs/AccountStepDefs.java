package com.ysf.local.cucumberImplementataion.stepDefs;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ysf.local.cucumberImplementataion.application.AccountService;
import com.ysf.local.cucumberImplementataion.common.AccountException;
import com.ysf.local.cucumberImplementataion.domaine.Account;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class AccountStepDefs {
	
	@Autowired
	private AccountService accountService;
	
	@Given("^the list of accounts is:$")
	public void the_list_of_accounts_is(List<DummyAccount> accounts) throws AccountException {
	  accounts.stream().forEach(account->{
			try {
				accountService.createAccount(new Account(account.accountId,account.accountOwner,account.balance,account.creationDate));
			} catch (AccountException e) {
				e.printStackTrace();
			}
	  });
	}

	@Given("^A user should be able to deposit a valid amount to a specific account$")
	public void a_user_should_be_able_to_deposit_a_valid_amount_to_a_specific_account() throws Throwable {
	    
	}

	@When("^a user request to deposit (\\d+)\\.(\\d+) to the account id (\\d+)$")
	public void a_user_request_to_deposit_to_the_account_id(int arg1, int arg2, int arg3) throws Throwable {
	   
	}

	@Then("^the amount of account become as bellow :$")
	public void the_amount_of_account_become_as_bellow(List<DummyAccount> arg1) throws Throwable {
	   
	}
	
	class DummyAccount{
		 Long accountId;
		 String accountOwner;
		 Double balance;
		 LocalDateTime creationDate;
	}
}
