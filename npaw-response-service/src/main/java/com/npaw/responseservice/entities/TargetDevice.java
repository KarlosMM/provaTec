package com.npaw.responseservice.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TargetDevice {

	@Id
	private Long idTargetDevice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ACCOUNT", nullable = false)
	private Account account;

	private String targetDevice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PLUGIN_VERSION", nullable = false)
	private Plugin plugin;

	private Short pingTime;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "targetDevice")
	private Set<TargetDeviceXCluster> targetDevicesXCluster = new HashSet<TargetDeviceXCluster>();

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

	public Plugin getPlugin() {
		return plugin;
	}

	public void setPlugin(Plugin plugin) {
		this.plugin = plugin;
	}

	public Short getPingTime() {
		return pingTime;
	}

	public void setPingTime(Short pingTime) {
		this.pingTime = pingTime;
	}

	public Set<TargetDeviceXCluster> getTargetDevicesXCluster() {
		return targetDevicesXCluster;
	}

	public void setTargetDevicesXCluster(Set<TargetDeviceXCluster> targetDevicesXCluster) {
		this.targetDevicesXCluster = targetDevicesXCluster;
	}

	@Override
	public String toString() {
		return "TargetDevice [targetDevice=" + targetDevice + "]";
	}

}
