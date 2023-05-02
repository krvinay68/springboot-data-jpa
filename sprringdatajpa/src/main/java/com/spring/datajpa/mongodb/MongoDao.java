package com.spring.datajpa.mongodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

public class MongoDao {

	
	@Autowired
	ProductMongoRespository productMongoRespository;
	
	public void insert() {
		 
		ProductMongo productMongo=new ProductMongo();
		productMongo.setName("GREEN");
		productMongo.setPrice(2000);
		ProductMongo save=productMongoRespository.save(productMongo);
	}
	public void read() {
		 
		List<ProductMongo> li=productMongoRespository.findAll();
	}
}
