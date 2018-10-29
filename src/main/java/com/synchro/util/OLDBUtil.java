package com.synchro.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


import com.synchro.dao.UpdataDao;

/**
 *连接oracle数据库工具类
 */
public class OLDBUtil {
	public static String className ;  
	public static String url ;  
	public static String username ;  
	public static String password ;
	public static Connection conn;
	private static void init(){

		Properties prop = new Properties();
		InputStream in = OLDBUtil.class.getClassLoader().getResourceAsStream( "config.properties" );
		
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		className=prop.getProperty("classname");
//		url=prop.getProperty("url");
//		username=prop.getProperty("username");
//		password=prop.getProperty("password");
		className=prop.getProperty("m-classname");
		url=prop.getProperty("m-url");
		username=prop.getProperty("m-username");
		password=prop.getProperty("m-password");
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
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
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
