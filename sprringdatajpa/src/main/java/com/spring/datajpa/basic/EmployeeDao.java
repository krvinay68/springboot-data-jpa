
/**
 * basic operations
 */

package com.spring.datajpa.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;

@Component
public class EmployeeDao {
	@Autowired
	EmployeeRepository employeeRepository;

	public void insertEmp() {

		List<EmployeeEntity> emplist = new ArrayList<>();

		emplist.add(new EmployeeEntity("BLUE", "002", "bangalore", "JAVA_8", "28"));
		emplist.add(new EmployeeEntity("Vinay", "003", "bangalore", "spring", "29"));
		emplist.add(new EmployeeEntity("RRR", "004", "bangalore", "spring-BOOT", "30"));
		emplist.add(new EmployeeEntity("AAA", "005", "bangalore", "spring-CLOUD", "31"));
		emplist.add(new EmployeeEntity("JJ", "006", "bangalore", "spring-WEB", "39"));
		emplist.add(new EmployeeEntity("Kumar", "007", "bangalore", "spring-REPO", "40"));

		// this for single row insertion
		employeeRepository.save(new EmployeeEntity("RED", "001", "bangalore", "JAVA", "55"));
		// this is for multiple row insertion
		employeeRepository.saveAll(emplist);
	}

	// THESE BELOW ALL ARE PREDIFINE METHODS
	public void findAllEmp() {
		List<EmployeeEntity> li = employeeRepository.findAll();
		li.stream().forEach(list -> {
			System.out.println("ID--> " + list.getId());
			System.out.println("NAME--> " + list.getName());
			System.out.println("EMPID--> " + list.getEmpid());
			System.out.println("ADDRR--> " + list.getAddress());
			System.out.println("DEPAR--> " + list.getDepartment());

		});
	}

	
	public void findEmpById() {
		EmployeeEntity e = employeeRepository.findById(1l).get();
		System.out.println("-------> " + e);
	}

	public void findUpdateById() {
		EmployeeEntity e = employeeRepository.findById(1l).get();
		e.setDepartment("xyz");
		employeeRepository.save(e);
		EmployeeEntity e2 = employeeRepository.findById(1l).get();
		System.out.println(">>>>>>>>>> " + e2);
	}

	public void DeleteById() {
		employeeRepository.deleteById(1l);
	}

	public void existsById() {
		boolean b = employeeRepository.existsById(1l);
		System.out.println(">>>>>>>>>> " + b);
	}

	public void countRecords() {
		long i = employeeRepository.count();
		System.out.println(">>>>>>>>>> " + i);
	}

	// ------------------------------------------------------

	// ----------- CUSTOM SELECT QYERIES --------------------
	public void getByname() {
		List<EmployeeEntity> list = employeeRepository.findByName("BLUE");
		list.stream().forEach(li -> {
			System.out.println("ID-->> " + li.getId());
			System.out.println("NAME-->> " + li.getName());
			System.out.println("EMPID-->> " + li.getEmpid());
			System.out.println("ADDRR-->> " + li.getAddress());
			System.out.println("DEPAR-->> " + li.getDepartment());
		});
	}

	public void getBynameAndDescription() {
		List<EmployeeEntity> list = employeeRepository.findByNameAndDepartment("BLUE", "JAVA_8");
		list.stream().forEach(li -> {
			System.out.println("ID-->> " + li.getId());
			System.out.println("NAME-->> " + li.getName());
			System.out.println("EMPID-->> " + li.getEmpid());
			System.out.println("ADDRR-->> " + li.getAddress());
			System.out.println("DEPAR-->> " + li.getDepartment());
		});
	}

	public void getByAgeGreatarThan() {
		List<EmployeeEntity> list = employeeRepository.findByAgeGreaterThan("29");
		list.stream().forEach(li -> {
			System.out.println("ID-->> " + li.getId());
			System.out.println("NAME-->> " + li.getName());
			System.out.println("EMPID-->> " + li.getEmpid());
			System.out.println("ADDRR-->> " + li.getAddress());
			System.out.println("DEPAR-->> " + li.getDepartment());
			System.out.println("DEPAR-->> " + li.getAge());
		});
	}

	public void getByNameContains() {
		List<EmployeeEntity> list = employeeRepository.findByNameContains("BLUE");
		list.stream().forEach(li -> {
			System.out.println("ID-->> " + li.getId());
			System.out.println("NAME-->> " + li.getName());
			System.out.println("EMPID-->> " + li.getEmpid());
			System.out.println("ADDRR-->> " + li.getAddress());
			System.out.println("DEPAR-->> " + li.getDepartment());
			System.out.println("DEPAR-->> " + li.getAge());
		});

	}

	public void getByBetween() {
		List<EmployeeEntity> list = employeeRepository.findByAgeBetween("20", "30");
		list.stream().forEach(li -> {
			System.out.println("ID-->> " + li.getId());
			System.out.println("NAME-->> " + li.getName());
			System.out.println("EMPID-->> " + li.getEmpid());
			System.out.println("ADDRR-->> " + li.getAddress());
			System.out.println("DEPAR-->> " + li.getDepartment());
			System.out.println("DEPAR-->> " + li.getAge());
		});

	}

	public void getByLike() {
		List<EmployeeEntity> list = employeeRepository.findByDepartmentLike("%JA%");
		list.stream().forEach(li -> {
			System.out.println("ID-->> " + li.getId());
			System.out.println("NAME-->> " + li.getName());
			System.out.println("EMPID-->> " + li.getEmpid());
			System.out.println("ADDRR-->> " + li.getAddress());
			System.out.println("DEPAR-->> " + li.getDepartment());
			System.out.println("DEPAR-->> " + li.getAge());
		});

	}

	public void getByAgeIn() {
		List<EmployeeEntity> list = employeeRepository.findByAgeIn(Arrays.asList("28", "31"));
		list.stream().forEach(li -> {
			System.out.println("ID-->> " + li.getId());
			System.out.println("NAME-->> " + li.getName());
			System.out.println("EMPID-->> " + li.getEmpid());
			System.out.println("ADDRR-->> " + li.getAddress());
			System.out.println("DEPAR-->> " + li.getDepartment());
			System.out.println("DEPAR-->> " + li.getAge());
		});

	}
	
	//it will enable leve1 cache per session
	@Transactional
	public void level_1cache() {		
		 employeeRepository.findById(1l).get();
		 employeeRepository.findById(1l).get();
	
	}
}
