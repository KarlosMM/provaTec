package com.npaw.responseservice.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account {

	@Id
	private Long idAccount;

	private String accountCode;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	private Set<TargetDevice> targetDevices = new HashSet<TargetDevice>();

	public Long getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public Set<TargetDevice> getTargetDevices() {
		return targetDevices;
	}

	public void setTargetDevices(Set<TargetDevice> targetDevices) {
		this.targetDevices = targetDevices;
	}

}
