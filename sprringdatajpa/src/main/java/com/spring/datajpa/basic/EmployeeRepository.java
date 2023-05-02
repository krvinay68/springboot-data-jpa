/**
 * This all about various SPRING DATA J P A FINDER METHODS AND ITS KEY WORDS TO USE TO CREATE OUR OWN SELECT QUERRIS
 * ALL BELOW ARE BASIC OPRERATION OR SELECT QUERY WILL GENERATE AUTOMATICALLY BY JPA
 * 
 **/


package com.spring.datajpa.basic;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>{
   
	//All are custom methods based sql queries
     List<EmployeeEntity> findByName(String name);
     List<EmployeeEntity> findByNameAndDepartment(String name,String department);
     List<EmployeeEntity> findByAgeGreaterThan(String age);
     List<EmployeeEntity> findByNameContains(String name);
     List<EmployeeEntity> findByAgeBetween(String age,String agee);
     List<EmployeeEntity> findByDepartmentLike(String dept);
     List<EmployeeEntity> findByAgeIn(List<String> age);
  
}
