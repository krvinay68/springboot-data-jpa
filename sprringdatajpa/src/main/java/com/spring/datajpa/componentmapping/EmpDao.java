package com.spring.datajpa.componentmapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmpDao {

	@Autowired
	EmpRepository empRepository;
	public void insert() {
		
		
		Employee employee=new Employee();
		Address address= new Address();
		employee.setName("RED");
		address.setAddress("BTM");
		address.setCity("BANG");
		address.setState("KAR");
		address.setCountry("IND");
		employee.setAddress(address);
		empRepository.save(employee);
		
	}
}
