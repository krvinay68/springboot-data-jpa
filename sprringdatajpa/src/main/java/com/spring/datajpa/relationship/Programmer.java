/**
 * THIS IS FOR MANAY TO MANY OF PROJECT CLASS
 * IF WANT TO PERFORM CRUD OPERATION PLEASE CREATE THE JpaRespository
 */

package com.spring.datajpa.relationship;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
public class Programmer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	private String name;
	private String salary;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "programmers_projects", joinColumns = @JoinColumn(name= "programmer_id", referencedColumnName = "id"), inverseJoinColumns =@JoinColumn(name="project_id",referencedColumnName = "id") )
	private Set<Project> project;
}
