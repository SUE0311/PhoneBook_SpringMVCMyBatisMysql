package com.jsnote.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jsnote.domain.PhoneBook;
import com.jsnote.persistence.PhoneService;
import com.jsnote.validator.RegistrationValidator;

@Controller
public class PhoneBookController {
	
	private RegistrationValidator validator = null;
	private PhoneService phoneService = null;
		
	@Autowired
	public void setPhoneService(PhoneService phoneService) {
		this.phoneService = phoneService;
	}

	public RegistrationValidator getValidator() {
		return validator;
	}

	@Autowired
	public void setValidator(RegistrationValidator validator) {
		this.validator = validator;
	}

	/*��ȭ��ȣ �Է� �� ����*/
	@RequestMapping(value="/**/addPhone", method=RequestMethod.GET)
	public String addForm(@ModelAttribute(value="phone") PhoneBook phone){
		return "addPhone";
	}
	
	/*��ȭ��ȣ ����Ʈ ����*/
	@RequestMapping(value="/**/listPhone", method=RequestMethod.GET)
	public String showPhoneBook(ModelMap model){
		List<PhoneBook> phones = phoneService.listPhone();
		model.addAttribute("phones", phones);
		return "listPhone";
	}
	
	/*���ο� ��ȭ��ȣ ���*/
	@RequestMapping(value="/**/addPhoneOk", method=RequestMethod.POST)
	public ModelAndView add(@ModelAttribute(value="phone") PhoneBook phone,BindingResult result){
		validator.validate(phone, result);
		ModelAndView mv = new ModelAndView("listPhone");
		if(!result.hasErrors()){
			phoneService.addPhoneOk(phone);
		}
		mv.addObject("phones", phoneService.listPhone());
		return mv;
	}

	/*id�� �˻��� ���� �� ����*/
	@RequestMapping(value="/**/updatePhone/id/{id}", method=RequestMethod.GET)
	public String updateForm(@PathVariable int id, ModelMap model){
		PhoneBook phone = phoneService.updatePhone(id);
		model.addAttribute("phone", phone);
		return "updatePhone";
	}
	
	/*��ȭ��ȣ ���� ����*/
	@RequestMapping(value="/**/updatePhoneOk", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute(value="phone") PhoneBook phone, BindingResult result){
		validator.validate(phone, result);
		ModelAndView mv = new ModelAndView("listPhone");
		if(!result.hasErrors()){
			phoneService.updatePhoneOk(phone);
		}
		mv.addObject("phones", phoneService.listPhone());
		return mv;
	}
	
	/*��ȭ��ȣ ����*/
	@RequestMapping(value="/**/deletePhone/id/{id}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id){
		ModelAndView mv = new ModelAndView("listPhone");
		phoneService.deletePhone(id);
		mv.addObject("phones", phoneService.listPhone());
		return mv;
	}
}
