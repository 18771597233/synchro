package com.synchro.entity;

public class Person  extends BaseInfo{
	private String seniorityPayDtMap;
	private String businessUnitDesc;
	private String deptDesc;
	private String businessUnit;
	private String eId;
	private String nameFormal;
	private String emplType;
	private String psimagever;
	private String emplPhotoURL;
	private String supvLvlId;
	private String supvLvlDesc;
	private String email;
	private String jobCodeDesc;
	private String jobCode;
	private String phone;
	private String sex;
	private String deptId;
	private String nameAc;
	private String birthDate;
	public Person(){}
	public Person(String seniorityPayDtMap, String businessUnitDesc, String deptDesc, String businessUnit, String eId,
			String nameFormal, String emplType, String psimagever, String emplPhotoURL, String supvLvlId,
			String supvLvlDesc, String email, String jobCodeDesc, String jobCode, String phone, String sex,
			String deptId, String nameAc, String birthDate) {
		super();
		this.seniorityPayDtMap = seniorityPayDtMap;
		this.businessUnitDesc = businessUnitDesc;
		this.deptDesc = deptDesc;
		this.businessUnit = businessUnit;
		this.eId = eId;
		this.nameFormal = nameFormal;
		this.emplType = emplType;
		this.psimagever = psimagever;
		this.emplPhotoURL = emplPhotoURL;
		this.supvLvlId = supvLvlId;
		this.supvLvlDesc = supvLvlDesc;
		this.email = email;
		this.jobCodeDesc = jobCodeDesc;
		this.jobCode = jobCode;
		this.phone = phone;
		this.sex = sex;
		this.deptId = deptId;
		this.nameAc = nameAc;
		this.birthDate = birthDate;
	}
	public String getSeniorityPayDtMap() {
		return seniorityPayDtMap;
	}
	public void setSeniorityPayDtMap(String seniorityPayDtMap) {
		this.seniorityPayDtMap = seniorityPayDtMap;
	}
	public String getBusinessUnitDesc() {
		return businessUnitDesc;
	}
	public void setBusinessUnitDesc(String businessUnitDesc) {
		this.businessUnitDesc = businessUnitDesc;
	}
	public String getDeptDesc() {
		return deptDesc;
	}
	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}
	public String getBusinessUnit() {
		return businessUnit;
	}
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
	public String geteId() {
		return eId;
	}
	public void seteId(String eId) {
		this.eId = eId;
	}
	public String getNameFormal() {
		return nameFormal;
	}
	public void setNameFormal(String nameFormal) {
		this.nameFormal = nameFormal;
	}
	public String getEmplType() {
		return emplType;
	}
	public void setEmplType(String emplType) {
		this.emplType = emplType;
	}
	public String getPsimagever() {
		return psimagever;
	}
	public void setPsimagever(String psimagever) {
		this.psimagever = psimagever;
	}
	public String getEmplPhotoURL() {
		return emplPhotoURL;
	}
	public void setEmplPhotoURL(String emplPhotoURL) {
		this.emplPhotoURL = emplPhotoURL;
	}
	public String getSupvLvlId() {
		return supvLvlId;
	}
	public void setSupvLvlId(String supvLvlId) {
		this.supvLvlId = supvLvlId;
	}
	public String getSupvLvlDesc() {
		return supvLvlDesc;
	}
	public void setSupvLvlDesc(String supvLvlDesc) {
		this.supvLvlDesc = supvLvlDesc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJobCodeDesc() {
		return jobCodeDesc;
	}
	public void setJobCodeDesc(String jobCodeDesc) {
		this.jobCodeDesc = jobCodeDesc;
	}
	public String getJobCode() {
		return jobCode;
	}
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getNameAc() {
		return nameAc;
	}
	public void setNameAc(String nameAc) {
		this.nameAc = nameAc;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "Person [seniorityPayDtMap=" + seniorityPayDtMap + ", businessUnitDesc=" + businessUnitDesc
				+ ", deptDesc=" + deptDesc + ", businessUnit=" + businessUnit + ", eId=" + eId + ", nameFormal="
				+ nameFormal + ", emplType=" + emplType + ", psimagever=" + psimagever + ", emplPhotoURL="
				+ emplPhotoURL + ", supvLvlId=" + supvLvlId + ", supvLvlDesc=" + supvLvlDesc + ", email=" + email
				+ ", jobCodeDesc=" + jobCodeDesc + ", jobCode=" + jobCode + ", phone=" + phone + ", sex=" + sex
				+ ", deptId=" + deptId + ", nameAc=" + nameAc + ", birthDate=" + birthDate + "]";
	}
	
	 
}
