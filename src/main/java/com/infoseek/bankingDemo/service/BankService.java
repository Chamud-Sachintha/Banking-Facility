package com.infoseek.bankingDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infoseek.bankingDemo.domain.Bank;
import com.infoseek.bankingDemo.repo.BankRepository;

@Service
public class BankService {
	
	private BankRepository bankRepository;
	
	@Autowired
	public BankService(BankRepository bankRepository) {
		this.bankRepository = bankRepository;
	}
	
	public Bank createBank(Bank newBank) {
		return this.bankRepository.save(newBank);
	}
	
	public List<Bank> getAllBanks(){
		return this.bankRepository.findAll();
	}
	
	public Optional<Bank> getBankByid(long bankId) {
		return this.bankRepository.findById(bankId);
	}
	
	public void deleteBankById(long bankId) {
		this.bankRepository.deleteById(bankId);
	}
	
	public Bank updateBank(Long bankId,Bank bankDetails) {
		Bank getSelectedBank = this.bankRepository.getById(bankId);
		
		if(getSelectedBank != null) {
			getSelectedBank.setBankName(bankDetails.getBankName());
			getSelectedBank.setIncooperateDate(bankDetails.getIncooperateDate());
			getSelectedBank.setNoOfBranches(bankDetails.getNoOfBranches());
			getSelectedBank.setNoOfStaff(bankDetails.getNoOfStaff());
			getSelectedBank.setBankStatus(bankDetails.getBankStatus());
		}
		
		return this.bankRepository.save(getSelectedBank);
	}
	
	public Optional<Bank> getBankByStatus(String bankStatus){
		return this.bankRepository.findByBankStatus(bankStatus);
	}
}
