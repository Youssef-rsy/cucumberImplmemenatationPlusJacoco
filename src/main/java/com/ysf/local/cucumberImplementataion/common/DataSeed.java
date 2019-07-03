package com.ysf.local.cucumberImplementataion.common;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.ysf.local.cucumberImplementataion.domaine.Account;
import com.ysf.local.cucumberImplementataion.infrastricture.AccountsRepository;

@Component
@Profile("dev")
public class DataSeed {

	@Autowired
	private AccountsRepository repos;
	Faker faker = new Faker();
	
	@PostConstruct
	public void createsAccounts() {
		for (int i = 0; i < 20; i++) {
			repos.save(new Account(faker.name().name() 
									,BigDecimal.valueOf(faker.random().nextDouble()+1000) ,LocalDateTime.now() ));
		}
	}
}
