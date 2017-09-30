package com.boco.handw.model;

import org.springframework.stereotype.Component;

@Component
public class Topo {
	/*
	 * 用户账号
	 */
	private String account;
	
	/*
	 * 开户带宽
	 */
	private String bandwidth;
	
	/*
	 * 安装地址
	 */
	private String address;
	
	/*
	 * ONU
	 */
	private String onu;
	
	/*
	 * 认证值
	 */
	private String authenValue;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBandwidth() {
		return bandwidth;
	}

	public void setBandwidth(String bandwidth) {
		this.bandwidth = bandwidth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOnu() {
		return onu;
	}

	public void setOnu(String onu) {
		this.onu = onu;
	}

	public String getAuthenValue() {
		return authenValue;
	}

	public void setAuthenValue(String authenValue) {
		this.authenValue = authenValue;
	}

	public Topo() {
	}

	public Topo(String account, String bandwidth, String address, String onu,
			String authenValue) {
		super();
		this.account = account;
		this.bandwidth = bandwidth;
		this.address = address;
		this.onu = onu;
		this.authenValue = authenValue;
	}
	

	public static Topo CreateTopo(String text) {
		String[] obj = text.split("<br>");
		if (obj.length != 5) {
			return null;
		} else {
			String account=obj[0].split("：")[1];
			String bandwidth=obj[1].split("：")[1];
			String address=obj[2].split("：")[1];
			String [] onu3=obj[3].split(":");//==null?obj[3].split(":"):obj[3].split("：");
			String onu=onu3[1];
			String authenValue=obj[4].split("：")[1];
			return new Topo(account,bandwidth ,address ,onu ,authenValue );
		}
	}
}
