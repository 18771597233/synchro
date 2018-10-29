package com.synchro.entity;

import java.util.HashMap;
import java.util.Map;

public class BaseInfo {
	public Map<String,String> value = null;
	public BaseInfo(){
		value = new HashMap<String, String>();
	}
	public Object put(String key,String value) {
		return this.value.put(key, value);
	}
	public String get(String key) {
		if(this.value.get(key) == null){
			return "";
		}
		return this.value.get(key).toString();
	}
}
