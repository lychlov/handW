package com.boco.handw.model;

import org.springframework.stereotype.Component;

@Component
public class Cmd602 implements ICmd {
	/*
	 * 本地小区标识
	 */
	private String cellId;

	/*
	 * 小区的实例状态̬
	 */
	private String cellStatus;

	/*
	 * 最近一次小区状态变化的原因
	 */
	private String latelyStaChangeReason;

	public String getCellId() {
		return cellId;
	}

	public void setCellId(String cellId) {
		this.cellId = cellId;
	}

	/*
	 * 基站标识
	 */
	private String bsic;

	public String getBsic() {
		return bsic;
	}

	public void setBsic(String bsic) {
		this.bsic = bsic;
	}

	/*
	 * 射频单元信息
	 */
	private String rf_unit_info;

	public String getRFUnitInfo() {
		return rf_unit_info;
	}

	public void setRFUnitInfo(String rf_unit_info) {
		this.rf_unit_info = rf_unit_info;
	}

	/*
	 * 发射通道号
	 */
	private String trans_chan;

	public String getTransChan() {
		return trans_chan;
	}

	public void setTransChan(String trans_chan) {
		this.trans_chan = trans_chan;
	}

	/*
	 * 接收通道号
	 */
	private String receive_chan;

	public String getReceiveChan() {
		return receive_chan;
	}

	public void setReceiveChan(String receive_chan) {
		this.receive_chan = receive_chan;
	}

	/*
	 * 服务基带处理板信息
	 */
	private String baseband;

	public String getBaseband() {
		return baseband;
	}

	public void setBaseband(String baseband) {
		this.baseband = baseband;
	}

	/*
	 * 工作状态
	 */
	private String work_status;

	public String getWorkStatus() {
		return work_status;
	}

	public void setWorkStatus(String work_status) {
		this.work_status = work_status;
	}

	public String getCellStatus() {
		return cellStatus;
	}

	public void setCellStatus(String cellStatus) {
		this.cellStatus = cellStatus;
	}

	public String getLatelyStaChangeReason() {
		return latelyStaChangeReason;
	}

	public void setLatelyStaChangeReason(String latelyStaChangeReason) {
		this.latelyStaChangeReason = latelyStaChangeReason;
	}

	public Cmd602() {
		super();
	}

	public Cmd602(String cellId, String cellStatus, String latelyStaChangeReason) {
		super();
		this.cellId = cellId;
		this.cellStatus = cellStatus;
		this.latelyStaChangeReason = latelyStaChangeReason;
	}

	public static Cmd602 CreateCmd602(String text) {
		if (text.contains("菜单"))
			return null;
		String Regex = "\\s+";
		String[] obj = text.split(Regex);
		// String[] obj = text.split(" ");
		if (obj.length < 2) {
			return null;
		} else {
			String cellId = "";
			String cellStatus = "";
			String latelyStaChangeReason = "";
			if (obj.length == 2) {
				cellId = obj[1];
			} else if (obj.length == 3) {
				cellId = obj[1];
				cellStatus = obj[2];
			} else if (obj.length == 4) {
				cellId = obj[1];
				cellStatus = obj[2];
				latelyStaChangeReason = obj[3];

			}
			return new Cmd602(cellId, cellStatus, latelyStaChangeReason);
		}
	}
}
