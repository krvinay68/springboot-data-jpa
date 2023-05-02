package com.spring.datajpa.jpql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JpqlItemEntityDao {

	@Autowired
	JpqlRespositoryItementity jpqlRespositoryItementity;
	
	public void findAllItemJPQL() {
		
		List<ItemEntity> list=jpqlRespositoryItementity.findAllItem();
		System.out.println("USING JAVA PERSISTENCE QUERY LANGUAGE");
		list.forEach(li -> {			
			System.out.println("USING BY JPQL--> " + li.getItemName());
		});
	}
public void findParitalItemJPQL() {
		
		List<Object[]> list=jpqlRespositoryItementity.findAllItemPartialData();
		System.out.println("USING JAVA PERSISTENCE QUERY LANGUAGE");
		for(Object[] obj : list) {
			System.out.println(obj[0]);
			System.out.println(obj[1]);
		}
		
	}
public void findAllItemBynameJPQL() {
	
	List<ItemEntity> list=jpqlRespositoryItementity.findAllItemByItemName("IPOD");
	System.out.println("USING JAVA PERSISTENCE QUERY LANGUAGE");
	list.forEach(li -> {			
		System.out.println("USING BY JPQL--> " + li.getItemName());
	});
}
public void findAllItemByPriceRangeJPQL() {
	
	List<ItemEntity> list=jpqlRespositoryItementity.findAllItemByItemPrice("20000", "40000");
	System.out.println("USING JAVA PERSISTENCE QUERY LANGUAGE");
	list.forEach(li -> {			
		System.out.println("USING BY JPQL--> " + li.getItemName());
	});
}
}
