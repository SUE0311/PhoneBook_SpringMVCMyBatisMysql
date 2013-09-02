package com.jsnote.domain;

public class PhoneBook {
	
	private int id;				/*아이디(연번)*/
	private String name;		/*이름*/
	private String tel;			/*연락처*/
	private String email;		/*이메일*/
	private String birthday;	/*생년월일*/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

}
