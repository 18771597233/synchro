package com.synchro.dao;

import java.util.List;
import java.util.Map;

import com.synchro.entity.Person;

public interface YmyyDao {
	//查询Ymyy表数据
	public List<Map<String, Object>> findAll(String eId);
	public List <Person> findAlls(String eId);
	//查询Ymyy表所有数据转为map数据
//	public Map<String, Person> findMap();

	
}
