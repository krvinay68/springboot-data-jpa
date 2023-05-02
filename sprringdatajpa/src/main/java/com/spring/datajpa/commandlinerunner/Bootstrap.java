package com.spring.datajpa.commandlinerunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.datajpa.basic.EmployeeDao;
import com.spring.datajpa.componentmapping.EmpDao;
import com.spring.datajpa.inheritance.JpaDataDao;
import com.spring.datajpa.jpql.ItemDaoPagination;
import com.spring.datajpa.jpql.JpqlItemEntityDao;
import com.spring.datajpa.relationship.CustomerDao;
import com.spring.datajpa.transactionmanagement.BankAccountImp;

@Component
public class Bootstrap implements CommandLineRunner{
	
	private Logger logger=LoggerFactory.getLogger(getClass());
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	ItemDaoPagination itemDaoPagination;
	
	@Autowired 
	JpqlItemEntityDao jpqlItemEntityDao;
	
	@Autowired
	JpaDataDao jpaDataDao;
	
	@Autowired
	EmpDao empDao;
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	BankAccountImp bankAccountImp;
	
	@Override
	public void run(String... args) throws Exception {
	
		employeeDao.insertEmp();
		employeeDao.findAllEmp();
		employeeDao.findEmpById();
		employeeDao.findUpdateById();
		employeeDao.DeleteById();
		employeeDao.existsById();
		employeeDao.countRecords();
		employeeDao.getByname();
		employeeDao.getBynameAndDescription();
		employeeDao.getByAgeGreatarThan();
		employeeDao.getByNameContains();
		employeeDao.getByBetween();
		employeeDao.getByLike();
		employeeDao.getByAgeIn();		
		//------------------------------
		itemDaoPagination.insertIlist();
		itemDaoPagination.findAllbyPaging();
		itemDaoPagination.findAllbyPagingSorting();
		itemDaoPagination.getByAgeInPagingAndSorting();
		//--------------------------------
		jpqlItemEntityDao.findAllItemJPQL();
		jpqlItemEntityDao.findParitalItemJPQL();
		jpqlItemEntityDao.findAllItemBynameJPQL();
		jpqlItemEntityDao.findAllItemByPriceRangeJPQL();
		//---------------------------------
		jpaDataDao.insert();
		jpaDataDao.insert2();
		//--------------------------------
		empDao.insert();
		//-----------------------------
		customerDao.insert();
		
	}

}
