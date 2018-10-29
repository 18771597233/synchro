package com.synchro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.synchro.entity.Person;
import com.synchro.util.DBUtil;
import com.synchro.util.HRConstant;
import com.synchro.util.HrSql;
import com.synchro.util.OLDBUtil;
import com.synchro.util.MqDBUtil;

public class FindDao {
	public FindDao(){
		if(HRConstant.mysqlcloums.length>0){
			for(int i=0;i<HRConstant.mysqlcloums.length;i++){
				if(i == (HRConstant.mysqlcloums.length-1) ){
					HRConstant.colStr.append(HRConstant.mysqlcloums[i]);
				}else{
					HRConstant.colStr.append(HRConstant.mysqlcloums[i]).append(",");
				}
			}
		}
		if(HRConstant.oraclecloums.length>0){
			for(int i=0;i<HRConstant.oraclecloums.length;i++){
				if(i == (HRConstant.oraclecloums.length-1) ){
					HRConstant.oracolStr.append(HRConstant.oraclecloums[i]);
				}else{
					HRConstant.oracolStr.append(HRConstant.oraclecloums[i]).append(",");
				}
			}
		}
	}
	//取mysql的全部数据到personmap
	public  Map<String, Person> getPersonData(Map<String, String> curIdMap,boolean is) {
	Map<String, Person> personMap = new HashMap<String, Person>();
    PreparedStatement ps= null;
    ResultSet resultSet = null;
    Connection con =  null;
	try {
		con = MqDBUtil.getConnection();
		ps = con.prepareStatement(HrSql.findmysqlsql);
		resultSet = ps.executeQuery();
		while (resultSet.next()) {
			Person person = new Person();
			//把所有字段的值放到 person
			if(HRConstant.mysqlcloums.length>0){
				for(int i=0;i<HRConstant.mysqlcloums.length;i++){
					person.put(HRConstant.mysqlcloums[i], resultSet.getString(HRConstant.mysqlcloums[i]));
				}
			}
		    personMap.put(person.get("eId"),person);
	    	curIdMap.put(person.get("eId"), person.get("eId"));
		 }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
			if(ps!=null){
					ps.close();
					resultSet.close();
				}
				MqDBUtil.closeConnection(con);
			} catch (SQLException e) {
				is = false;
				e.printStackTrace();
			}
		}
		return personMap;
	}
	//取oracle全部的记录 到personOlmap
	public Map<String, Person> getPersonOlData(Map<String, String> olIdMap,boolean is) {
		 	Map<String,Person> personMap = new HashMap<String,Person>();
			Connection conn = null;
	        PreparedStatement ps= null;
	        ResultSet resultSet = null;
			try {
			    conn = OLDBUtil.getConnection();
				ps = conn.prepareStatement(HrSql.findoraclelsql);
				resultSet = ps.executeQuery();
				while (resultSet.next()) {
					Person person = new Person();
					//把所有字段的值放到 person
					if(HRConstant.arry.length>0){
						boolean falg=false;
						for(int i=0;i<HRConstant.arry.length;i++){
							person.put(HRConstant.arry[i], resultSet.getString(HRConstant.arry[i]));
						}
					}
				    personMap.put(person.get("eId"),person);
				    olIdMap.put(person.get("eId"), person.get("eId"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					resultSet.close();
					ps.close();
					OLDBUtil.closeConnection(conn);
				} catch (Exception e) {
					is = false;
					e.printStackTrace();
				}
			}
			return personMap;
	}
}
