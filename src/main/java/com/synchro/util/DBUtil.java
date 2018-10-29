package com.synchro.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;



/**
 *连接Oracle数据库工具类
 */
public class DBUtil {
	public static String className ;  
	public static String url ;  
	public static String username ;  
	public static String password ;
	public static Connection conn;
	static {
		Properties prop=new Properties();
		InputStream in = DBUtil.class.getClassLoader().getResourceAsStream( "config.properties" );
		try {
			prop.load(in);
//			prop.load(new FileInputStream("src/config.properties"));
			className=prop.getProperty("classname").trim();
			url=prop.getProperty("url").trim();
			username=prop.getProperty("username").trim();
			password=prop.getProperty("password").trim();
			Class.forName(className);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * 获取连接
	 */
	public static Connection getConnection() throws Exception{
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
