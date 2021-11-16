package com.nlb.loanservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlb.loanservice.entity.LoanApplication;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Integer>{

}
