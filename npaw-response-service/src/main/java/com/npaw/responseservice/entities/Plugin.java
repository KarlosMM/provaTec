package com.npaw.responseservice.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Plugin {

	@Id
	private Long idPluginVersion;

	private String pluginVersion;

	public Long getIdPluginVersion() {
		return idPluginVersion;
	}

	public void setIdPluginVersion(Long idPluginVersion) {
		this.idPluginVersion = idPluginVersion;
	}

	public String getPluginVersion() {
		return pluginVersion;
	}

	public void setPluginVersion(String pluginVersion) {
		this.pluginVersion = pluginVersion;
	}

	@Override
	public String toString() {
		return "Plugin [idPluginVersion=" + idPluginVersion + ", pluginVersion=" + pluginVersion + "]";
	}

}
