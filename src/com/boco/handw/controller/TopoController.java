package com.boco.handw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.boco.handw.model.Topo;
import com.boco.handw.util.HttpGet;
import com.boco.handw.util.PropertyConfig;

@Controller
public class TopoController {

	@RequestMapping("/topo")
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		ModelAndView mv = new ModelAndView();
		Topo topo = null;
		
		String uuid = req.getParameter("uuid").toString();
		boolean retJson = PropertyConfig.getProperty("return").equals("json");
		String url = String.format("%s%s", PropertyConfig.getProperty(retJson ? "query_json_url" : "query_string_url"), uuid);
		if (url != null && url != "") {
			String result = HttpGet.Get(url);
			if (result != null && result != "") {
				if (retJson) {
					String resultEn = PropertyConfig.ReplaceFieldNameChEoEn(result, "topo_field_map");
					JSONObject obj = JSONObject.fromObject(resultEn);
					topo = (Topo)JSONObject.toBean(obj, Topo.class);
				} else {
					topo = ParseTopoString(result);
				}
			}
	
			mv.addObject("obj", topo);
			mv.setViewName("Topo");
		}
		return mv;
	}	
	
	private Topo ParseTopoString(String text) {
		return Topo.CreateTopo(text);
	}
}