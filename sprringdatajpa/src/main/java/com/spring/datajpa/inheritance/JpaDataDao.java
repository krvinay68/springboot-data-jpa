package com.spring.datajpa.inheritance;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JpaDataDao {

	@Autowired
	BankRepository bankRepository;
	
	@Autowired
	BankRepositoryy bankRepositoryy;
	public void insert() {
		
		List<CurrentAccountEntity> li= new ArrayList<>();
		li.add(new CurrentAccountEntity(20000000.00,"vinay kumar","10000"));
		bankRepository.saveAll(li);
	}
public void insert2() {
		
		List<SavingAccountEntity> li= new ArrayList<>();
		li.add(new SavingAccountEntity(20000000.00,"vinay kumar","10000"));
		bankRepositoryy.saveAll(li);
	}
}
