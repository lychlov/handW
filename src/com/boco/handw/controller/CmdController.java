package com.boco.handw.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.boco.handw.model.Cmd402;
import com.boco.handw.model.Cmd602;
import com.boco.handw.util.HttpGet;
import com.boco.handw.util.PropertyConfig;

@Controller
public class CmdController {
	@SuppressWarnings("unchecked")
	@RequestMapping("/cmd")
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mv = new ModelAndView();

		String type = req.getParameter("type").toString();
		String uuid = req.getParameter("uuid").toString();
		boolean retJson = PropertyConfig.getProperty("return").equals("json");
		String url = String.format("%s%s", PropertyConfig.getProperty(retJson ? "query_json_url" : "query_string_url"), uuid);
		if (url != null && url != "") {
			// String result = HttpGet.Get(url);
			String result = "3333";
			List<String> resultList = HttpGet.listGet(url);//
			// test402Data();

			if (resultList != null && resultList.size() > 0) {
				if (retJson) {
					String resultEn = PropertyConfig.ReplaceFieldNameChEoEn(result, String.format("cmd%s_field_map", type));
					JSONArray array = JSONArray.fromObject(resultEn);
					if (type.equals("402")) {
						List<Cmd402> cmdList = (List<Cmd402>) JSONArray.toCollection(array, Cmd402.class);
						mv.addObject("obj", cmdList);
					} else {
						if (type.equals("602")) {
							List<Cmd602> cmdList = (List<Cmd602>) JSONArray.toCollection(array, Cmd602.class);
							mv.addObject("obj", cmdList);
						}
					}
				} else {
					if (type.equals("402")) {
						// List<Cmd402> cmdList = ParseCmd402String(result);
						List<Cmd402> cmdList = ParseCmd402String(resultList);
						mv.addObject("obj", cmdList);
					} else {
						if (type.equals("602")) {
							// List<Cmd602> cmdList = ParseCmd602String(result);
							List<Cmd602> cmdList = ParseCmd602String(resultList);
							mv.addObject("obj", cmdList);
						}
					}
				}
			}
			mv.addObject("type", type);
			mv.setViewName("Cmd");
		}
		return mv;
	}

	@RequestMapping("/cmd602")
	public ModelAndView Request602(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mv = new ModelAndView();

		String uuid = req.getParameter("uuid").toString();
		boolean retJson = PropertyConfig.getProperty("return").equals("json");
		String url = String.format("%s%s", PropertyConfig.getProperty(retJson ? "query_json_url" : "query_string_url"), uuid);
		if (url != null && url != "") {

			List<String> resultList = HttpGet.listGet(url);//
			// test602Data(); //

			if (resultList != null && resultList.size() > 0) {

				// List<Cmd602> cmdList = ParseCmd602String(result);
				List<Cmd602> cmdList = ParseCmd602String(resultList);
				mv.addObject("obj", cmdList);

			}
			mv.setViewName("Cmd602");
		}
		return mv;
	}

	private List<Cmd402> ParseCmd402String(String text) {
		List<Cmd402> cmd402List = new ArrayList<Cmd402>();
		String[] lines = text.split("<br>");
		for (int i = 1; i < lines.length; i++) {
			Cmd402 cmd402 = Cmd402.CreateCmd402(lines[i]);
			if (cmd402 != null) {
				cmd402List.add(cmd402);
			}
		}

		return cmd402List;
	}

	private List<Cmd402> ParseCmd402String(List<String> lines) {
		List<Cmd402> cmd402List = new ArrayList<Cmd402>();
		for (int i = 0; i < lines.size(); i++) {
			String line = lines.get(i);
			if (line.contains("|")) {
				Cmd402 cmd402 = Cmd402.CreateCmd402(line);
				if (cmd402 != null) {
					cmd402List.add(cmd402);
				}
			}
		}

		return cmd402List;
	}

	private List<Cmd602> ParseCmd602String(String text) {
		List<Cmd602> cmd602List = new ArrayList<Cmd602>();
		while (text.startsWith("<br>")) {
			text = text.substring(4);
		}

		String[] lines = text.split("<br>");
		for (int i = 1; i < lines.length; i++) {

			Cmd602 cmd602 = Cmd602.CreateCmd602(lines[i]);
			if (cmd602 != null) {
				cmd602List.add(cmd602);
			}
		}

		return cmd602List;
	}

	private List<Cmd602> ParseCmd602String(List<String> listLine) {
		List<Cmd602> cmd602List = new ArrayList<Cmd602>();
		List<String> lines = new ArrayList<String>();
		for (String line : listLine) {
			if (!line.trim().equals(""))
				lines.add(line);

		}
		if (lines.get(0).split("\\|").length != 9) {
			for (String line : lines) {
				Cmd602 cmd602 = Cmd602.CreateCmd602(line);
				if (cmd602 != null)
					cmd602List.add(cmd602);
			}
		} else {
			for (String line : lines) {
				if (line.contains("菜单") || line.contains("|") || line.trim() == "")
					continue;
				Cmd602 cmd602 = createCmd602(line);

				cmd602List.add(cmd602);

			}
		}

		return cmd602List;
	}

	private List<String> test602Data() {
		List<String> cmd402List = new ArrayList<String>();
		cmd402List.add("本地小区标识|小区的实例状态|最近一次小区状态变化的原因|基站标识|射频单元信息|发射通道号|接收通道号|服务基带处理板信息|工作状态");
		cmd402List.add("  0       领峰小区1#-3#B1F-6F及4#-6#       正常     235718    0-62-0        R0B         R0B         0-0-2               正常   ");
		cmd402List.add(" 0       领峰小区1#-3#B1F-6F及4#-6#       正常     235718    0-64-0        R0B         R0B         0-0-2               正常               ");
		cmd402List.add("  0       领峰小区1#-3#B1F-6F及4#-6#       正常     235718    0-61-0        R0B         R0B         0-0-2               正常               ");
		cmd402List.add("  0       领峰小区1#-3#B1F-6F及4#-6#       正常     235718    0-70-0        R0B         R0B         0-0-2               正常               ");
		cmd402List.add("  0       领峰小区1#-3#B1F-6F及4#-6#       正常     235718    0-68-0        -           -           -                   无可用的RRU载波资源");
		return cmd402List;
	}

	private List<String> test602Data2() {
		List<String> cmd402List = new ArrayList<String>();
		cmd402List.add("本地小区标识|小区的实例状态|最近一次小区状态变化的原因");
		cmd402List.add("  0       领峰小区1#-3#B1F-6F及4#-6#       正常     ");
		cmd402List.add(" 0       领峰小区1#-3#B1F-6F及4#-6#       正常     ");
		cmd402List.add("  0       领峰小区1#-3#B1F-6F及4#-6#       正常     ");
		cmd402List.add("  0       领峰小区1#-3#B1F-6F及4#-6#       正常    ");
		cmd402List.add("  0       领峰小区1#-3#B1F-6F及4#-6#       正常     ");
		return cmd402List;
	}

	private Cmd602 createCmd602(String text) {

		Cmd602 cmd602 = new Cmd602();

		String Regex = "\\s+";
		String[] obj = text.trim().split(Regex);
		for (int i = 0; i < obj.length; i++) {
			String strCmd = obj[i];
			switch (i) {
			case 0:
				cmd602.setCellId(strCmd);
				break;
			case 1:
				cmd602.setCellStatus(strCmd);
				break;
			case 2:
				// 最近一次小区状态变化的原因
				cmd602.setLatelyStaChangeReason(strCmd);
				break;
			case 3:
				// 基站标识|||||

				cmd602.setBsic(strCmd);
				break;
			case 4:
				// 射频单元信息
				cmd602.setRFUnitInfo(strCmd);
				break;
			case 5:
				// 发射通道号
				cmd602.setTransChan(strCmd);
				break;
			case 6:
				// 接收通道号
				cmd602.setReceiveChan(strCmd);
				break;
			case 7:
				// 服务基带处理板信息
				cmd602.setBaseband(strCmd);
				break;
			case 8:
				// 工作状态
				cmd602.setWorkStatus(strCmd);
				break;

			}
		}
		return cmd602;
	}
}
