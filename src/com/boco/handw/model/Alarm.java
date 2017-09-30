package com.boco.handw.model;

import org.springframework.stereotype.Component;

@Component
public class Alarm {
	/*
	 * 序号
	 */
	private String num;

	/*
	 * 网元名称
	 */
	private String neName;

	/*
	 * 所属区县
	 */
	private String region;

	/*
	 * 设备厂家
	 */
	private String vender;

	/*
	 * 告警发生时间
	 */
	private String alarmTime;

	/*
	 * 厂家告警号
	 */
	private String alarmNum;

	/*
	 * 告警中文名
	 */
	private String alarmTitle;

	/*
	 * 告警对象名称
	 */
	private String alarmStation;

	/*
	 * 基站编号
	 */
	private String stationNum;

	/*
	 * 基站名称
	 */
	private String stationName;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getNeName() {
		return neName;
	}

	public void setNeName(String neName) {
		this.neName = neName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getVender() {
		return vender;
	}

	public void setVender(String vender) {
		this.vender = vender;
	}

	public String getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(String alarmTime) {
		this.alarmTime = alarmTime;
	}

	public String getAlarmNum() {
		return alarmNum;
	}

	public void setAlarmNum(String alarmNum) {
		this.alarmNum = alarmNum;
	}

	public String getAlarmTitle() {
		return alarmTitle;
	}

	public void setAlarmTitle(String alarmTitle) {
		this.alarmTitle = alarmTitle;
	}

	public String getAlarmStation() {
		return alarmStation;
	}

	public void setAlarmStation(String alarmStation) {
		this.alarmStation = alarmStation;
	}

	public String getStationNum() {
		return stationNum;
	}

	public void setStationNum(String stationNum) {
		this.stationNum = stationNum;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public Alarm() {
	}

	public Alarm(String num, String neName, String region, String vender, String alarmTime, String alarmNum, String alarmTitle, String alarmStation, String stationNum, String stationName) {
		this.num = num;
		this.neName = neName;
		this.region = region;
		this.vender = vender;
		this.alarmTime = alarmTime;
		this.alarmNum = alarmNum;
		this.alarmTitle = alarmTitle;
		this.alarmStation = alarmStation;
		this.stationNum = stationNum;
		this.stationName = stationName;
	}

	public static Alarm CreateAlarm(String text) {
		String[] obj = text.split("\\|");
		if (obj.length != 10) {
			return null;
		} else {
			return new Alarm(obj[0], obj[1], obj[2], obj[3], obj[4], obj[5], obj[6], obj[7], obj[8], obj[9]);
		}
	}
}
