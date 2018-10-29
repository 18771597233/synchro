package com.synchro.util;

public class HRConstant {
	public static StringBuffer colStr = new StringBuffer();
	public static StringBuffer oracolStr = new StringBuffer();
	public static String [] arry = {"eId","nameFormal","supvLvlId","email","jobCodeDesc","phone","sex","deptId","birthDate"};
	public static String [] mysqlcloums = {"seniorityPayDtMap","businessUnitDesc",
			"deptDesc","businessUnit","eId","nameFormal",
			"emplType","psimagever","emplPhotoURL","supvLvlId",
			"supvLvlDesc","email","jobCodeDesc","jobCode","phone",
			"sex","deptId","nameAc","birthDate"};
	public static String [] oraclecloums ={"CRC_CHN_NAME as nameFormal",
			"CRC_EMAIL_KEY as email","MOBILE_PHONE as phone","EMPLID as eId","SUPV_LVL_ID as supvLvlId",
			"SEX as sex","DEPTID as deptId","CRC_JOINCRC_DT as jobCodeDesc","BIRTHDATE as birthDate"};
	/*public static String [] oraclecloums ={"﻿CRC_CHN_NAME","DEPT_DESCR","JOBCODE_DESCR",
			"CRC_EMAIL_KEY","MOBILE_PHONE","EMPLID","CRC_EMPSTATUS_DESC","SUPV_LVL_ID",
			"SEX","EMPL_STATUS","CRC_COMP_DESCR","CRC_LASTUPDATE","DEPTID","CRC_JOINCRC_DT","BIRTHDATE"};"﻿CRC_CHN_NAME as nameFormal ",*/
}
