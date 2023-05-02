/**
 * THIS IS FOR ONE TO ONE OF License CLASS
 * IF WANT TO PERFORM CRUD OPERATION PLEASE CREATE THE JpaRespository
 */

package com.spring.datajpa.relationship;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	private String first_name;
	private String last_name;
	int age;
	@OneToOne(mappedBy = "person")
	private License license;
}
