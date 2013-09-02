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

	/*전화번호 입력 폼 보기*/
	@RequestMapping(value="/**/addPhone", method=RequestMethod.GET)
	public String addForm(@ModelAttribute(value="phone") PhoneBook phone){
		return "addPhone";
	}
	
	/*전화번호 리스트 보기*/
	@RequestMapping(value="/**/listPhone", method=RequestMethod.GET)
	public String showPhoneBook(ModelMap model){
		List<PhoneBook> phones = phoneService.listPhone();
		model.addAttribute("phones", phones);
		return "listPhone";
	}
	
	/*새로운 전화번호 등록*/
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

	/*id로 검색한 수정 폼 보기*/
	@RequestMapping(value="/**/updatePhone/id/{id}", method=RequestMethod.GET)
	public String updateForm(@PathVariable int id, ModelMap model){
		PhoneBook phone = phoneService.updatePhone(id);
		model.addAttribute("phone", phone);
		return "updatePhone";
	}
	
	/*전화번호 정보 수정*/
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
	
	/*전화번호 삭제*/
	@RequestMapping(value="/**/deletePhone/id/{id}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id){
		ModelAndView mv = new ModelAndView("listPhone");
		phoneService.deletePhone(id);
		mv.addObject("phones", phoneService.listPhone());
		return mv;
	}
}
