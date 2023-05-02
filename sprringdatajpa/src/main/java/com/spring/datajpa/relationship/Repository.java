/**
 * EXAMPLE OF ONE TO MANY AND MANY TO ONE
 */

package com.spring.datajpa.relationship;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Customer, Long>{ 

}
