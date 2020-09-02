package com.npaw.responseservice.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TargetDevice {

	@Id
	private Long idTargetDevice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ACCOUNT", nullable = false)
	private Account account;

	private String targetDevice;

	private String pluginVersion;

	private Short pingTime;

	public Long getIdTargetDevice() {
		return idTargetDevice;
	}

	public void setIdTargetDevice(Long idTargetDevice) {
		this.idTargetDevice = idTargetDevice;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getTargetDevice() {
		return targetDevice;
	}

	public void setTargetDevice(String targetDevice) {
		this.targetDevice = targetDevice;
	}

	public String getPluginVersion() {
		return pluginVersion;
	}

	public void setPluginVersion(String pluginVersion) {
		this.pluginVersion = pluginVersion;
	}

	public Short getPingTime() {
		return pingTime;
	}

	public void setPingTime(Short pingTime) {
		this.pingTime = pingTime;
	}

}
