package com.synchro.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *连接mysql数据库工具类
 */
public class MqDBUtil {
	public static String className ;  
	public static String url ;  
	public static String username ;  
	public static String password ;
	public static Connection conn;
	private static void init(){
		Properties prop=new Properties();
		InputStream in = MqDBUtil.class.getClassLoader().getResourceAsStream( "config.properties" );
		try {
			prop.load(in);
			className=prop.getProperty("m2-classname").trim();
			url=prop.getProperty("m2-url").trim();
			username=prop.getProperty("m2-username").trim();
			password=prop.getProperty("m2-password").trim();
			Class.forName(className);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * 获取连接
	 */
	public static Connection getConnection(){
		init();
		if(conn == null){
		}
		return  conn;
	}
	/*
	 * 断开连接
	 */
	public static void closeConnection(Connection conn){
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
