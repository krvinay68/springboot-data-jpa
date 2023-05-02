package com.spring.datajpa.inheritance;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SAVING")
//@PrimaryKeyJoinColumn(name="Id")//only we have to use with JOINED
public class SavingAccountEntity extends BankDetialsEntity{

private String accountNumber;
	
	public SavingAccountEntity() {
	}	
	public SavingAccountEntity(double amount , String name, String accountNumber) {
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
