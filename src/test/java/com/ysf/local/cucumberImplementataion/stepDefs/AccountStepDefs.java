package com.ysf.local.cucumberImplementataion.stepDefs;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.hamcrest.core.IsEqual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
	private List<Account> listAccount;
	private Account account;
	private String exception;
	
	@Given("^the list of accounts is:$")
	public void the_list_of_accounts_is(List<DummyAccount> accounts)  {
	  accounts.stream().forEach(account->{
		  LocalDateTime creationDate = LocalDateTime.parse(account.creationDate, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		  try {
			accountService.createAccount(new Account(account.accountId,account.accountOwner,account.balance,
					creationDate));
		} catch (AccountException e) {
			e.printStackTrace();
		}
	  });
		
	}
	
	@Given("^I'm connected as Admin$")
	public void i_m_connected_as_Admin() throws Throwable {
		assertTrue(true);
	}

	@When("^T want to list all accounts$")
	public void t_want_to_list_all_accounts() throws Throwable {
		listAccount = accountService.accounts();
	}

	@Then("^I get the following list:$")
	public void i_get_the_following_list(List<DummyAccount> lists) throws Throwable {
		assertThat(lists.size(), is(2));
	}
	

	@Given("^I'm connected as user(\\d+)$")
	public void i_m_connected_as_user(int arg1) throws Throwable {
		assertTrue(true);
	}

	@When("^I try to deposit (\\d+.\\d+) to the account id (\\d+)$")
	public void i_try_to_deposit_to_the_account_id(BigDecimal balance, long id) throws Throwable {
		account = accountService.credit(id,balance);
	}

	@Then("^the amount of account becomes as bellow (\\d+.\\d+)$")
	public void the_amount_of_account_becomes_as_bellow(BigDecimal newBalance) throws Throwable {
		assertThat(newBalance,is( account.getBalance()));
	}
	
	@When("^I try to retreive (\\d+.\\d+) fromthe account id (\\d+)$")
	public void i_try_to_retreive_fromthe_account_id(BigDecimal balance, long id) throws Throwable {
		account =  accountService.debit(id, balance);
	}

	@Then("^the amount will become (\\d+.\\d+)$")
	public void the_amount_will_become(BigDecimal newBalance) throws Throwable {
		assertThat(newBalance, Matchers.comparesEqualTo(account.getBalance()) );
	}	
	
	@When("^I try to retreive (\\d+.\\d+) from the account id (\\d+)$")
	public void i_try_to_retreive_from_the_account_id(BigDecimal balance, long id) throws AccountException {
			try{
				accountService.debit(id, balance);
			}catch (AccountException e) {
				exception = e.getMessage();
			}
	}

	@Then("^i get the following error : \"([^\"]*)\"$")
	public void i_get_the_following_error(String arg1) throws Throwable {
		assertEquals(arg1, exception);
	}
	
	class DummyAccount{
		 Long accountId;
		 String accountOwner;
		 BigDecimal balance;
		 String creationDate;
	}
}
