package com.spring.datajpa.caching;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;

@Component
public class CachingDao {
	@Autowired
	CachingRepo cachingRepo;
	
	@Autowired
	   EntityManager entityManager;

	public void insertEmp() {

		List<ExamCaching> emplist = new ArrayList<>();
		ExamCaching examCaching= new ExamCaching();
				
		examCaching.setAddress("BLUE");
		examCaching.setAge("002");
		examCaching.setEmpid("bangalore");
		examCaching.setName("JAVA_8");
		examCaching.setDepartment("28");
	
		emplist.add(examCaching);
     	// this is for multiple row insertion
		cachingRepo.saveAll(emplist);
	}

	// THESE BELOW ALL ARE PREDIFINE METHODS
	@Transactional
	public void findAllEmp() {
		Session session=entityManager.unwrap(Session.class);
		ExamCaching obj=cachingRepo.findById(1).get();
		cachingRepo.findById(1).get();
		//removing the obj form level1 cache
		session.evict(obj);		
		
		cachingRepo.findById(1).get();
	}


}
