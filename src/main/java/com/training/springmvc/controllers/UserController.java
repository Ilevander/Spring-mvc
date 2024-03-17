package com.training.springmvc.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.springmvc.models.UserModel;
import com.training.springmvc.models.UserModelValid;


@Controller
@RequestMapping("/test")
public class UserController {
	
	//@URL : http://localhost:8080/spring-mvc/test/user-registration-form
	@RequestMapping("/user-registration-form")
	public String userReegistrationForm(Model model) {
		model.addAttribute("user", new UserModel());
		return "userRegistrationForm";
	}
	
	
	//@URL : http://localhost:8080/spring-mvc/test/create-user
	@RequestMapping("/create-user")
	public String createUser(@ModelAttribute("user") UserModel u) {
		// store user into the database or perform other business valuable operation
		System.out.println(u);
		return "registrationConfirmation";
	}
	
	
	//@URL : http://localhost:8080/spring-mvc/test/create-user-wtih-validation
	@RequestMapping("/user-registration-form-with-validation")
	public String userReegistrationFormWithValidation(Model model) {
		model.addAttribute("user", new UserModelValid());
		return "userRegistrationFormWithValidation";
	}
	
	
	//@URL : http://localhost:8080/spring-mvc/test/create-user-wtih-validation
	@RequestMapping("/create-user-wtih-validation")
	public String createUserWithValidation(@Valid @ModelAttribute("user") UserModelValid u, 
			BindingResult br) {
		System.out.println("Are there any data binding errors? " + br.hasErrors());
		
		
//		// ================= EXAMPLE of BindingResult API ====================
//		
//		List<FieldError> fieldErrors = br.getFieldErrors();
//		for (FieldError fieldError : fieldErrors) {
//			System.out.println(fieldError.getDefaultMessage());
//		}
//		
//		// ================= EXAMPLE of Programmatic way to validate object ====================
//		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//		Validator validator = factory.getValidator();
//		Set<ConstraintViolation<UserModelValid>> violations = validator.validate(u);
//		for (ConstraintViolation<UserModelValid> constraintViolation : violations) {
//			System.out.println(constraintViolation.getMessage());
//		}
		
		
		if (br.hasErrors()) {
			return "userRegistrationFormWithValidation";
		} else {
			return "registrationConfirmation";
		}
		
	}
	
	// ======= USER REGISTRATION for Spring Security Demo
	
	@RequestMapping("/user-registration-form-security-demo")
	public String userReegistrationSecurityDemo(Model model) {
		model.addAttribute("user", new UserModelValid());
		return "userRegistrationSecurityDemo";
	}
	
	
}
