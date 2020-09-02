package com.npaw.responseservice.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TARGET_DEVICE_X_CLUSTER")
public class TargetDeviceXCluster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6528483066306196201L;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLUSTER", nullable = false)
	private Cluster cluster;

	private BigDecimal percentage;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TARGET_DEVICE", nullable = false)
	private TargetDevice targetDevice;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PLUGIN_VERSION", nullable = false)
	private Plugin plugin;

	public Cluster getCluster() {
		return cluster;
	}

	public void setCluster(Cluster cluster) {
		this.cluster = cluster;
	}

	public BigDecimal getPercentage() {
		return percentage;
	}

	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}

	public TargetDevice getTargetDevice() {
		return targetDevice;
	}

	public void setTargetDevice(TargetDevice targetDevice) {
		this.targetDevice = targetDevice;
	}

	public Plugin getPlugin() {
		return plugin;
	}

	public void setPlugin(Plugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public String toString() {
		return "TargetDeviceXCluster [cluster=" + cluster + ", percentage=" + percentage + ", targetDevice="
				+ targetDevice + "]";
	}

}
