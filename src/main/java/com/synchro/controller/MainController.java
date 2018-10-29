package com.synchro.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.apache.log4j.Logger;

import com.synchro.service.CheckData;
public class MainController {
	static Logger log= Logger.getLogger(MainController.class);
	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SS");
		TimeZone t = sdf.getTimeZone();
		t.setRawOffset(0);
		sdf.setTimeZone(t);
		Long startTime = System.currentTimeMillis();
		log.info("调用input方法");
		CheckData checkdata = new CheckData();
		checkdata.input();
		Long endTime = System.currentTimeMillis();
		System.out.println("用时：" + sdf.format(new Date(endTime - startTime)));
		}
}
