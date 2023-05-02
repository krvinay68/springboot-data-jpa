/**
 * THIS IS FOR MANAY TO MANY OF PROJECT CLASS
 * IF WANT TO PERFORM CRUD OPERATION PLEASE CREATE THE JpaRespository
 */


package com.spring.datajpa.relationship;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	@ManyToMany(mappedBy = "project")
	private Set<Programmer> programmer;
}
