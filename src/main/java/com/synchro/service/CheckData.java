package com.synchro.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import com.synchro.dao.FindDao;
import com.synchro.dao.UpdataDao;
import com.synchro.entity.Person;
import com.synchro.util.personUtil;

public class CheckData {
	/*
	 * 	增删改
	 */
	public boolean input() throws Exception {
		boolean is = true;
		//存oracle person 唯一表示
		Map<String, String> olIdMap = new HashMap<String, String>();
		//存现在myslq person 唯一表示
		Map<String, String> curIdMap = new HashMap<String, String>();
		//存添加数据
		Map<String, Person> addmap = new HashMap<String, Person>();
		//存修改的数据
		List<Person> modifylist = new ArrayList<Person>();
		//存删除的数据
		Map<String, Person> removemap = new HashMap<String, Person>();
		FindDao finddao = new FindDao();
		UpdataDao update = new UpdataDao();
		//取oracle全部的记录 到personOlmap 
		Map<String, Person> personOlmap = finddao.getPersonOlData(olIdMap,is);
		//取mysql现在的全部数据到persomap
		Map<String, Person> persomap = finddao.getPersonData(curIdMap,is);
		//删除数据
		
		if(!curIdMap.isEmpty()){
			Set entrySet = curIdMap.keySet();
			Iterator iterator  = entrySet.iterator();
			while(iterator.hasNext()){
				String key = iterator.next().toString();
				if(!olIdMap.containsKey(key)){//删除
					Person person = persomap.get(key);
					removemap.put(key, person);
				}
			}
		}
		update.removeData(removemap,is);
		
		//对比 数据判断新增或修改
		if(!olIdMap.isEmpty()){
			Set entrySet = olIdMap.keySet();
			Iterator iterator  = entrySet.iterator();
			while(iterator.hasNext()){
				String key = iterator.next().toString();
				if(curIdMap.containsKey(key)){//包含 修改
					Person	 myvalue = (Person)persomap.get(key);
					Person olvalue = (Person)personOlmap.get(key);
			        personUtil.comparePerson(myvalue,olvalue,modifylist);
				}else{//新增
					Person person = personOlmap.get(key);
					addmap.put(key, person);
				}
			}
		}
        update.modifyData(modifylist,is);
		update.addPersonData(addmap,is);
		return is;
	}
}
	


