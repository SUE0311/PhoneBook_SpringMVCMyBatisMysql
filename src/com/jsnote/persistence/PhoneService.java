package com.jsnote.persistence;

import java.util.List;

import com.jsnote.domain.PhoneBook;

public interface PhoneService {
	
	/*��� ����*/
	public List<PhoneBook> listPhone();
	/*���� ���*/
	public void addPhoneOk(PhoneBook phone);
	/*���̵�� �˻�*/
	public PhoneBook updatePhone(int id);
	/*���� ����*/
	public void updatePhoneOk(PhoneBook phone);
	/*���� ����*/
	public void deletePhone(int id);	
}
