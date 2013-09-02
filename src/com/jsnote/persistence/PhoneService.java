package com.jsnote.persistence;

import java.util.List;

import com.jsnote.domain.PhoneBook;

public interface PhoneService {
	
	/*목록 보기*/
	public List<PhoneBook> listPhone();
	/*새로 등록*/
	public void addPhoneOk(PhoneBook phone);
	/*아이디로 검색*/
	public PhoneBook updatePhone(int id);
	/*정보 수정*/
	public void updatePhoneOk(PhoneBook phone);
	/*정보 삭제*/
	public void deletePhone(int id);	
}
