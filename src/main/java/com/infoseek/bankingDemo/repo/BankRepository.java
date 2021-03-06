package com.infoseek.bankingDemo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infoseek.bankingDemo.domain.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {
	
	public Optional<Bank> findByBankStatus(String bankStatus);
}
