package com.infoseek.bankingDemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infoseek.bankingDemo.domain.Bank;
import com.infoseek.bankingDemo.service.BankService;

@RestController
@RequestMapping(path = "api/v1/bank")
public class BankController {
	
	private BankService bankService;
	
	@Autowired
	public BankController(BankService bankService) {
		this.bankService = bankService;
	}

	@PostMapping
	public Bank createBank(@RequestBody Bank newBank) {
		return this.bankService.createBank(newBank);
	}
	
	@GetMapping
	public List<Bank> getAllBanks(){
		return this.bankService.getAllBanks();
	}
	
	@GetMapping(path = "{bankId}")
	public Optional<Bank> getBankById(@PathVariable Long bankId){
		return this.bankService.getBankByid(bankId);
	}
	
	@DeleteMapping(path = "{bankId}")
	public void deleteBankById(@PathVariable Long bankId) {
		this.bankService.deleteBankById(bankId);
	}
}
