package com.jsnote.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jsnote.domain.PhoneBook;

//@Component : <context:component-scan base-package="com.jsnote" />
@Component
public class RegistrationValidator implements Validator {

	public boolean supports(Class<?> c) {
		return PhoneBook.class.isAssignableFrom(c);
	}

	public void validate(Object command, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.name.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tel", "field.tel.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.email.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthday", "field.birthday.empty");
	}
}
