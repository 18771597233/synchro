package com.synchro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.synchro.entity.Person;
import com.synchro.util.HRConstant;
import com.synchro.util.HrSql;
import com.synchro.util.MqDBUtil;

public class UpdataDao {
	static Logger log= Logger.getLogger(UpdataDao.class);
	//删除mysql多出来的数据
	public  void removeData(Map<String, Person> removemap,boolean is) {
		if(removemap.isEmpty()){
			return;
		}
		log.info("删除person:"+removemap.size());
		Connection conn = null;
        PreparedStatement ps= null;
		try {
			log.info("删除sql"+HrSql.removesql);
			conn = MqDBUtil.getConnection();
			ps = conn.prepareStatement(HrSql.removesql);
			Set<String> addSet = removemap.keySet();
			Iterator iterator = addSet.iterator();
			while(iterator.hasNext()){
				 String key = iterator.next().toString();
				 ps.setString(1, key);
				 ps.executeUpdate();
			}
		} catch (Exception e) {
			log.info("删除数据异常："+e);
			e.printStackTrace();
		}finally {
			try {
			if(ps!=null){
				ps.close();
			}
			MqDBUtil.closeConnection(conn);
			} catch (SQLException e) {
				is = false;
				e.printStackTrace();
			}
		}
	}
	//修改mysql数据
	public  void modifyData(List<Person> modifylist,boolean is) {
		if(modifylist.size()<1){
			return;
		}
		Connection conn = null;
		PreparedStatement ps=null;
		try {
			log.info("修改sql:"+HrSql.modifysql);
			conn = MqDBUtil.getConnection();
			ps = conn.prepareStatement(HrSql.modifysql);
			conn.setAutoCommit(false);
			for(Person person:modifylist){
				 if(HRConstant.arry.length>0){
					for(int i=1;i<HRConstant.arry.length;i++){
						ps.setString(i,person.get(HRConstant.arry[(i)]));
					}
					ps.setString(HRConstant.arry.length,person.get(HRConstant.arry[0]));
			 	 }
				 ps.addBatch();
				}
			ps.executeBatch();
			conn.commit();
		}catch (SQLException e) {
			log.info("sql语句异常："+e);
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null){
					ps.close();
				}
				MqDBUtil.closeConnection(conn);
				} catch (SQLException e) {
					is = false;
					e.printStackTrace();
			}
		}
	}
	//增加mysql数据
	public  void addPersonData(Map<String, Person>addmap,boolean is) {
		if(addmap.isEmpty()){
			return;
		}
		Connection conn =  null;
        PreparedStatement ps=null;
		try {
			conn = MqDBUtil.getConnection();
			log.info("添加sql:"+HrSql.addsql);
			System.out.println("添加sql:"+HrSql.addsql);
			ps = conn.prepareStatement(HrSql.addsql);
			Set<String> addSet = addmap.keySet();
			Iterator iterator = addSet.iterator();
			conn.setAutoCommit(false);
			while(iterator.hasNext()){
				 String key = iterator.next().toString();
				 Person person = addmap.get(key);
				 if(HRConstant.arry.length>0){
					for(int i=0;i<HRConstant.arry.length;i++){
						ps.setString(i+1,person.get(HRConstant.arry[i]));
					}
			 	 }
				 ps.addBatch();
			}
			ps.executeBatch();
			conn.commit();
		}catch (SQLException e) {
			log.info("sql语句异常："+e);
			e.printStackTrace();
		} finally {
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					is = false;
					e.printStackTrace();
				}
			}
			MqDBUtil.closeConnection(conn);
		}
	}
}
