package com.ysf.local.cucumberImplementataion.domaine;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * @author YOUSSEF ROSSAMY
 *
 */
@Entity
//@Data @NoArgsConstructor @AllArgsConstructor
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long accountId;
	private String accountOwner;
	private BigDecimal balance;
	private LocalDateTime creationDate;
	
	
	
	public Account() {
		super();
	}
	
	
	public Account(String accountOwner, BigDecimal balance, LocalDateTime creationDate) {
		super();
		this.accountOwner = accountOwner;
		this.balance = balance;
		this.creationDate = creationDate;
	}


	public Account(Long accountId, String accountOwner, BigDecimal balance, LocalDateTime creationDate) {
		super();
		this.accountId = accountId;
		this.accountOwner = accountOwner;
		this.balance = balance;
		this.creationDate = creationDate;
	}


	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getAccountOwner() {
		return accountOwner;
	}
	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	
	
}
