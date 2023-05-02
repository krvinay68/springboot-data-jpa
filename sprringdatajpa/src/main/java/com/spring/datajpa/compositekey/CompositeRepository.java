package com.spring.datajpa.compositekey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


public interface CompositeRepository extends JpaRepository<CompositeExample, CompositeKeyId>{

}
