package com.synchro.util;

import java.util.List;

import com.synchro.entity.Person;

public class personUtil {
public static void  comparePerson(Person myvalue,Person olvalue,List<Person> modifylist){
	 if(HRConstant.arry.length>0){
		boolean ismy = false;
		for(int i=1;i<HRConstant.arry.length;i++){
			String myColVlaue = myvalue.get(HRConstant.arry[(i)]);
			String olColVlaue = olvalue.get(HRConstant.arry[(i)]);
			if(myColVlaue == null ){
				myColVlaue = "";
			}
			if(olColVlaue == null ){
				olColVlaue = "";
			}
			if(!myColVlaue.equals(olColVlaue)){
				olvalue.put(olvalue.get(HRConstant.arry[(i)]), olColVlaue);
				ismy = true;
			}
		}
		if(ismy){
			modifylist.add(olvalue);
		}
 	 }
}
}
