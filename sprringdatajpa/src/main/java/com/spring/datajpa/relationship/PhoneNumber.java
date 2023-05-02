/**
 * EXAMPLE OF ONE TO MANY AND MANY TO ONE
 */

package com.spring.datajpa.relationship;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class PhoneNumber {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String number;
	private String type;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	
}
