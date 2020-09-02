package com.npaw.responseservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npaw.responseservice.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> { 
	Account findByAccountCode (final String accountCode);
}
