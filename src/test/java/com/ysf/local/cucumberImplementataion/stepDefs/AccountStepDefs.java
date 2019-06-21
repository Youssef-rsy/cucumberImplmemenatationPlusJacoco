package com.ysf.local.cucumberImplementataion.stepDefs;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.ysf.local.cucumberImplementataion.ApplicationTestConfig;
import com.ysf.local.cucumberImplementataion.application.AccountService;
import com.ysf.local.cucumberImplementataion.common.AccountException;
import com.ysf.local.cucumberImplementataion.domaine.Account;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration(classes = ApplicationTestConfig.class)
public class AccountStepDefs {
	
	@Autowired
	private AccountService accountService;
	private Account account;
	
	@Given("^the list of accounts is:$")
	public void the_list_of_accounts_is(List<DummyAccount> accounts) throws AccountException {
		System.out.println("################## 1 ##################");
	  accounts.stream().forEach(account->{
			try {
				accountService.createAccount(new Account(account.accountId,account.accountOwner,account.balance,
						account.creationDate));
			} catch (AccountException e) {
				e.printStackTrace();
			}
	  });
		
	}

	@Given("^I'm connected as user(\\d+)$")
	public void i_m_connected_as_user(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(true);
	}

	@When("^I try to deposit (\\d+)\\.(\\d+) to the account id (\\d+)$")
	public void i_try_to_deposit_to_the_account_id(double balance, long id) throws Throwable {
		account = accountService.credit(id,balance);
	}

	@Then("^the amount of account becomes as bellow (\\d+)\\.(\\d+)$")
	public void the_amount_of_account_becomes_as_bellow(double arg1, int arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(arg1 , java.util.Optional.ofNullable(account.getBalance()));
	}
	
	class DummyAccount{
		 Long accountId;
		 String accountOwner;
		 Double balance;
		 LocalDateTime creationDate;
	}
}
