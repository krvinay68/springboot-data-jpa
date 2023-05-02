package com.spring.datajpa.mongodb;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductMongo {
	
	@Id
	private String id;
	private String name;
	private float price;	

}
