/**
 * EXAMPLE OF ONE TO MANY AND MANY TO ONE
 */

package com.spring.datajpa.relationship;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerDao {

	@Autowired
	Repository repository;
	public void insert() {
		
		Customer customer=new Customer();
		customer.setName("RED");
		PhoneNumber ph1=new PhoneNumber();
		ph1.setType("MOB");
		ph1.setNumber("222332");
		
		
		PhoneNumber ph2=new PhoneNumber();
		ph2.setType("LAND LINE");
		ph2.setNumber("1111");
			
		customer.addPhoneNumber(ph1);
		customer.addPhoneNumber(ph2);
		repository.save(customer);
	}
}
