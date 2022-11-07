package com.mycom.myapp.house.dto;


public class HouseDto {
	private int no; // no
	private int houseId; // PK house no join houseInfo
	private String sido;
	private String gugun;
	private String dong;
	private String aptName;
	private String code; // gugun code
	private String dealAmount;
	private String buildYear;
	private String dealYear;
	private String dealMonth;
	private String dealDay;
	private String area;
	private String floor;
	private String type;
	private String jibun;
	private String rentMoney;
	private String lat; // 위도
	private String lng; // 경도
	private String img; // 아파트 이미지


	public int getHouseSeq() {
		return no;
	}


	public void setHouseSeq(int no) {
		this.no = no;
	}


	public int getHouseId() {
		return houseId;
	}


	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}


	public String getSido() {
		return sido;
	}


	public void setSido(String sido) {
		this.sido = sido;
	}


	public String getGugun() {
		return gugun;
	}


	public void setGugun(String gugun) {
		this.gugun = gugun;
	}


	public String getDong() {
		return dong;
	}


	public void setDong(String dong) {
		this.dong = dong;
	}


	public String getAptName() {
		return aptName;
	}


	public void setAptName(String aptName) {
		this.aptName = aptName;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getDealAmount() {
		return dealAmount;
	}


	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}


	public String getBuildYear() {
		return buildYear;
	}


	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}


	public String getDealYear() {
		return dealYear;
	}


	public void setDealYear(String dealYear) {
		this.dealYear = dealYear;
	}


	public String getDealMonth() {
		return dealMonth;
	}


	public void setDealMonth(String dealMonth) {
		this.dealMonth = dealMonth;
	}


	public String getDealDay() {
		return dealDay;
	}


	public void setDealDay(String dealDay) {
		this.dealDay = dealDay;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getFloor() {
		return floor;
	}


	public void setFloor(String floor) {
		this.floor = floor;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getJibun() {
		return jibun;
	}


	public void setJibun(String jibun) {
		this.jibun = jibun;
	}


	public String getRentMoney() {
		return rentMoney;
	}


	public void setRentMoney(String rentMoney) {
		this.rentMoney = rentMoney;
	}


	public String getLat() {
		return lat;
	}


	public void setLat(String lat) {
		this.lat = lat;
	}


	public String getLng() {
		return lng;
	}


	public void setLng(String lng) {
		this.lng = lng;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	@Override
	public String toString() {
		return "HouseDto [no=" + no + ", houseId=" + houseId + ", sido=" + sido
		    + ", gugun=" + gugun + ", dong=" + dong + ", aptName=" + aptName + ", code=" + code
		    + ", dealAmount=" + dealAmount + ", buildYear=" + buildYear + ", dealYear=" + dealYear
		    + ", dealMonth=" + dealMonth + ", dealDay=" + dealDay + ", area=" + area + ", floor="
		    + floor + ", type=" + type + ", jibun=" + jibun + ", rentMoney=" + rentMoney + ", lat="
		    + lat + ", lng=" + lng + ", img=" + img + "]";
	}

}
