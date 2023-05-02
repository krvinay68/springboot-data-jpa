package com.spring.datajpa.inheritance;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("CURRENT")
//@PrimaryKeyJoinColumn(name="Id")//only we have to use with JOINED
public class CurrentAccountEntity extends BankDetialsEntity {

	private String accountNumber;
	
	public CurrentAccountEntity() {
	}	
	public CurrentAccountEntity(double amount , String name, String accountNumber) {
		super(amount,name);
		this.accountNumber = accountNumber;
	}


	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	
	
}
