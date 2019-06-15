package com.hk.healthcare.dto;

public class user {
	
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getAlert() {
		return alert;
	}
	public void setAlert(String alert) {
		this.alert = alert;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public int getFailnum() {
		return failnum;
	}
	public void setFailnum(int failnum) {
		this.failnum = failnum;
	}
	private String password;
    private String name;
    private String phone;
    private String address;
    private String birth;
    private String gender;
    private String email;	
    private int point;
    private String alert;
    private String admin;
    private String height;
    private String weight;
    private int failnum;
    
	@Override
	public String toString() {
		return "user [id=" + id + ", password=" + password + ", name=" + name + ", phone=" + phone + ", address="
				+ address + ", birth=" + birth + ", gender=" + gender + ", email=" + email + ", point=" + point
				+ ", alert=" + alert + ", admin=" + admin + ", height=" + height + ", weight=" + weight + ", failnum="
				+ failnum + "]";
	}
	public user(String id, String password, String name, String phone, String address, String birth, String gender,
			String email, int point, String alert, String admin, String height, String weight, int failnum) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.birth = birth;
		this.gender = gender;
		this.email = email;
		this.point = point;
		this.alert = alert;
		this.admin = admin;
		this.height = height;
		this.weight = weight;
		this.failnum = failnum;
	}
	public user() {
		super();
	}
	
	
	
	
}
