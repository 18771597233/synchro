package com.synchro.util;

public class HrSql {
	public static  String addsql = 
			"insert into rel_crland_ymyy ("+HRConstant.colStr.toString()+") "
			+ "values(null,null,null,null,?,?,null,null,null,?,null,?,?,null,?,?,?,null,?)";
	public static  String removesql  =
			" delete from rel_crland_ymyy where eId = ? ";
	public static  String modifysql="update rel_crland_ymyy set nameFormal=?,supvLvlId=?,email=?,jobCodeDesc=?,phone=?,sex=?,deptId=?,birthDate=? where eId=?";
	public static  String findmysqlsql =
			"select "+ HRConstant.colStr +" from rel_crland_ymyy";
	public static  String findoraclelsql=
			"select "+HRConstant.oracolStr+" from rel_crland_ydyy";
	
}
