package com.spring.datajpa.inheritance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<CurrentAccountEntity, Long>{
}
 interface BankRepositoryy extends JpaRepository<SavingAccountEntity, Long>{
}
