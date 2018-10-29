//package com.synchro.controller;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.TimeZone;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.synchro.service.CheckData;
//@PropertySource("classpath:config.properties")
//@Component("task")  
//public class Task {
//	static Logger log= Logger.getLogger(Task.class);
//	@Scheduled(cron="${cron}")
//	public void run() {
//		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SS");
//		TimeZone t = sdf.getTimeZone();
//		t.setRawOffset(0);
//		sdf.setTimeZone(t);
//		Long startTime = System.currentTimeMillis();
//		log.info("调用input方法");
//		CheckData checkdata = new CheckData();
//		try {
//			checkdata.input();
//		} catch (Exception e) {
//			log.info("异常信息:"+e);
//			e.printStackTrace();
//		}
//		Long endTime = System.currentTimeMillis();
//		System.out.println("用时：" + sdf.format(new Date(endTime - startTime)));
////		System.out.println(cronn);
//    }  
//}
