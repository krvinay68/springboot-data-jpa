/**
 * EXAMPLE OF ONE TO MANY AND MANY TO ONE
 */


package com.spring.datajpa.relationship;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CollectionType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Customer {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<PhoneNumber> numbers;
	
	//BETTER WAY TO HANDLING FOREIGN KEY
	public void addPhoneNumber(PhoneNumber number) {
		if(number!=null) {
			if(numbers==null) {
				numbers=new HashSet<>();				
			}
			number.setCustomer(this);
			numbers.add(number);
			
		}
		
	}
}
