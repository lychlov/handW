package com.boco.handw.model;

import org.springframework.stereotype.Component;

@Component
public class Cmd402 implements ICmd {
	/*
	 * 对象编号
	 */
	private String objectId;
	/*
	 * 工作状态
	 */
	private String workStatus;
	/*
	 * TRX频点
	 */
	private String txrFrequency;

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	public String getTxrFrequency() {
		return txrFrequency;
	}

	public void setTxrFrequency(String txrFrequency) {
		this.txrFrequency = txrFrequency;
	}

	public Cmd402() {
		super();
	}

	public Cmd402(String objectId, String workStatus, String txrFrequency) {
		super();
		this.objectId = objectId;
		this.workStatus = workStatus;
		this.txrFrequency = txrFrequency;
	}

	public static Cmd402 CreateCmd402(String text) {
		String[] obj = text.split("\\|");
		if (obj.length != 3) {
			return null;
		} else {
			return new Cmd402(obj[0], obj[1], obj[2]);
		}
	}
}
