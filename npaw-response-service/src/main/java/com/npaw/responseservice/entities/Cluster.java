package com.npaw.responseservice.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cluster {

	@Id
	private Long idCluster;

	private String clusterName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cluster")
	private Set<TargetDeviceXCluster> targetDevicesXCluster = new HashSet<TargetDeviceXCluster>();

	public Long getIdCluster() {
		return idCluster;
	}

	public void setIdCluster(Long idCluster) {
		this.idCluster = idCluster;
	}

	public String getClusterName() {
		return clusterName;
	}

	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}

	public Set<TargetDeviceXCluster> getTargetDevicesXCluster() {
		return targetDevicesXCluster;
	}

	public void setTargetDevicesXCluster(Set<TargetDeviceXCluster> targetDevicesXCluster) {
		this.targetDevicesXCluster = targetDevicesXCluster;
	}

	@Override
	public String toString() {
		return "Cluster [idCluster=" + idCluster + ", clusterName=" + clusterName + "]";
	}

}
