package com.boco.handw.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.boco.handw.model.Alarm;
import com.boco.handw.util.HttpGet;
import com.boco.handw.util.PropertyConfig;

@Controller
public class AlarmController {

	@SuppressWarnings("unchecked")
	@RequestMapping("/alarm")
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<Alarm> alarmList = null;

		String uuid = req.getParameter("uuid").toString();
		boolean retJson = PropertyConfig.getProperty("return").equals("json");
		String url = String.format("%s%s", PropertyConfig.getProperty(retJson ? "query_json_url" : "query_string_url"), uuid);
		if (url != null && url != "") {

			/*
			 * String result = HttpGet.Get(url); if (result != null && result !=
			 * "") { if (retJson) { String resultEn =
			 * PropertyConfig.ReplaceFieldNameChEoEn(result, "alarm_field_map");
			 * JSONArray array = JSONArray.fromObject(resultEn); alarmList =
			 * (List<Alarm>) JSONArray.toCollection(array, Alarm.class); } else
			 * { alarmList = ParseAlarmString(result); } }
			 */

			List<String> result = HttpGet.listGet(url);
			if (result != null && result.size() > -1) {

				alarmList = ParseAlarmString(result);

			}

			mv.addObject("obj", alarmList);
			mv.setViewName("Alarm");

			//
			try {
				for (Alarm bean : alarmList) {
					bean.getAlarmNum();
					bean.getNum();
					bean.getNeName();
					bean.getRegion();
					;
					bean.getVender();
					bean.getAlarmTime();
					bean.getAlarmNum();
					bean.getAlarmTitle();
					bean.getAlarmStation();
					bean.getStationNum();
					bean.getStationName();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mv;
	}

	private List<Alarm> ParseAlarmString(String text) {
		List<Alarm> alarmList = new ArrayList<Alarm>();
		String[] lines = text.split("<br>");
		for (int i = 1; i < lines.length; i++) {
			if (lines[i].contains("|")) {
				Alarm alarm = Alarm.CreateAlarm(lines[i]);
				alarmList.add(alarm);
			}
		}

		return alarmList;
	}

	private List<Alarm> ParseAlarmString(List<String> lines) {
		List<Alarm> alarmList = new ArrayList<Alarm>();
		for (String lineString : lines) {
			if (lineString.contains("|") && !lineString.contains("序号")) {
				Alarm alarm = Alarm.CreateAlarm(lineString);
				alarmList.add(alarm);
			}
		}

		return alarmList;
	}
}
