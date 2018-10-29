package com.synchro.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.synchro.service.CheckData;
import com.synchro.service.PersonService;
import com.synchro.util.JsonResult;

@Controller
@RequestMapping("/restful")
public class ActionController {
	static Logger log= Logger.getLogger(ActionController.class);
	private CheckData checkdata = null;
	@Resource
	private PersonService personservice;
 	@RequestMapping("/employee")
    @ResponseBody
    public JsonResult<List<Map<String, Object>>> action(String eId){
 		log.info("调用ymdddao.finddata()");
 		List<Map<String, Object>> map=personservice.finddata(eId);
        return new JsonResult<List<Map<String, Object>>>(map);
    }
 	@RequestMapping("/update")
    @ResponseBody
    public JsonResult<String> update(){
 		String msg = null;
 		checkdata = new CheckData();
		boolean falg = false;
		try {
			falg = checkdata.input();
		} catch (Exception e) {
			e.printStackTrace();
		}
		msg = falg?"同步成功":"同步失败请重新同步";
        return new JsonResult<String>(msg);
    }
 	@RequestMapping("/demo")
    @ResponseBody
    public JsonResult<String> demo(){
 		String msg = "test123";
        return new JsonResult<String>(msg);
    }
}
