package com.synchro.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.synchro.dao.YmyyDao;
import com.synchro.entity.Person;

@Service("personService")

public class PersonServiceimplent implements PersonService {
	@Resource
	private YmyyDao ymdddao;
	public List<Map<String,Object>> finddata(String eId) {
		if(eId.isEmpty()&eId==null){
			try {
				throw new Exception("参数为空");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		List<Map<String,Object>> result = ymdddao.findAll(eId);
		List<Person> person = ymdddao.findAlls(eId);
		for(int i=0;i<person.size();i++){
			Map<String,Object>map = new HashMap<String, Object>();
			map = result.get(i);
			System.out.println(map);
			map.put("info", person.get(i));
			System.out.println(map);
		}
		return result;
	}
	
}
