package com.infoseek.bankingDemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infoseek.bankingDemo.domain.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {

}
