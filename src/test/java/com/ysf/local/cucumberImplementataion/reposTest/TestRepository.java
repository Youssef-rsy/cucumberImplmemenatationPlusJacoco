package com.ysf.local.cucumberImplementataion.reposTest;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import com.ysf.local.cucumberImplementataion.domaine.Account;
import com.ysf.local.cucumberImplementataion.infrastricture.AccountsRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@Profile("TEST")
@FixMethodOrder(MethodSorters.DEFAULT)
public class TestRepository {
	
	@Autowired
	private AccountsRepository repos;
	private Account account ;
	private List<Account> accounts;
	
	@Test
	public void findAll() {
		accounts = repos.findAll();
		assertThat(10, equalTo(accounts.size()));
	}
	
	@Test
	public void SaveAccount() {
		 account = new Account("accountOwner", new BigDecimal(2558763.29), LocalDateTime.now());
		 repos.save(account);
		 accounts = repos.findAll();
		 assertThat(11, equalTo(accounts.size()));
	}
	
	@Test
	public void  getAccount() {
		getOne();
		 assertThat("youssef rossamy", equalTo(account.getAccountOwner()));
	}

	public void getOne() {
		Optional<Account> optAccount = repos.findById((long) 1);
		 if(optAccount.isPresent())
			 account=optAccount.get();
		 else
			 fail("can't get data from repository");
	}
	
	@Test
	public void updateAccount() {
		 getOne();
		 BigDecimal newBalance = new BigDecimal(199876230.009);
		 account.setBalance(newBalance);
		 repos.saveAndFlush(account);
		 account = repos.getOne((long)1);
		 assertEquals("youssef rossamy", account.getAccountOwner());
		 assertEquals(newBalance, account.getBalance());
	}
	
	@Test
	public void delete() {
		 repos.deleteById((long)10);
		 accounts = repos.findAll();
		 assertThat(9, equalTo(accounts.size()));
	}

}
