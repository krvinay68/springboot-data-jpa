package com.spring.datajpa.transactionmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankAccountImp  implements BankAccountService{

	@Autowired
	BankAccRepository bankAccRepository;
	
	@Override
	//to enable transaction
	@Transactional
	public void transfer(int amount) {
		
		BankAccount redbankAccount=bankAccRepository.findById(1).get();
		redbankAccount.setBal(redbankAccount.getBal()-amount);
		bankAccRepository.save(redbankAccount);
		
		BankAccount bluebankAccount=bankAccRepository.findById(2).get();
		bluebankAccount.setBal(bluebankAccount.getBal()+amount);
		bankAccRepository.save(bluebankAccount);
	}

}
