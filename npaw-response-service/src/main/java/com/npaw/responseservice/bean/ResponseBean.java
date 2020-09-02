package com.npaw.responseservice.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "host", "pingTime", "viewCode" })
@XmlRootElement(name = "q")
public class ResponseBean {

	private String host;

	private Short pingTime;

	private String viewCode;

	public String getHost() {
		return host;
	}

	@XmlElement(name = "h")
	public void setHost(String host) {
		this.host = host;
	}

	public Short getPingTime() {
		return pingTime;
	}

	@XmlElement(name = "pt")
	public void setPingTime(Short pingTime) {
		this.pingTime = pingTime;
	}

	public String getViewCode() {
		return viewCode;
	}

	@XmlElement(name = "c")
	public void setViewCode(String viewCode) {
		this.viewCode = viewCode;
	}

}
