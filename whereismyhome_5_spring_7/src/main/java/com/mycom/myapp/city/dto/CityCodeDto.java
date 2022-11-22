package com.mycom.myapp.city.dto;

public class CityCodeDto {
	private String option;
	private String sidoName;
	private String sidoCode;
	private String gugunName;
	private String gugunCode;
	private String dongName;
	private String dongCode;
	private String lawdcd;

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getSidoName() {
		return sidoName;
	}

	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}

	public String getSidoCode() {
		return sidoCode;
	}

	public void setSidoCode(String sidoCode) {
		this.sidoCode = sidoCode;
	}

	public String getGugunName() {
		return gugunName;
	}

	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}

	public String getGugunCode() {
		return gugunCode;
	}

	public void setGugunCode(String gugunCode) {
		this.gugunCode = gugunCode;
	}

	public String getDongName() {
		return dongName;
	}

	public void setDongName(String dongName) {
		this.dongName = dongName;
	}

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public String getLawdcd() {
		return lawdcd;
	}

	public void setLawdcd(String lawdcd) {
		this.lawdcd = lawdcd;
	}

	@Override
	public String toString() {
		return "CityCodeDto [option=" + option + ", sidoName=" + sidoName + ", sidoCode=" + sidoCode + ", gugunName="
				+ gugunName + ", gugunCode=" + gugunCode + ", dongName=" + dongName + ", dongCode=" + dongCode
				+ ", lawdcd=" + lawdcd + "]";
	}

}
