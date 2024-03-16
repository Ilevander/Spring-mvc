package com.training.springmvc.controllers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/test")
public class ModelDemoController {
	
	//@URL : http://localhost:8080/spring-mvc/test/simple-model-demo
	@RequestMapping("/simple-model-demo")
	public String simpleModelDemo(Model model) {
		model.addAttribute("messageFromController", "This is test message #1 , From the First Controller");
		return "simpleModelDemo";
	}
	
	
	
	//@URL : http://localhost:8080/spring-mvc/test/request-session-injection-demo?test=toto
	@RequestMapping("/request-session-injection-demo")
	public String requestSessionInjectionDemo(HttpServletRequest req, HttpSession session) {
		String reqParam = req.getParameter("test");
		req.setAttribute("requestMsg", reqParam);
		session.setAttribute("sessionMsg", "Hello Session test message");
		
		return "requestSessionInjectionDemo";
	}
	
	
	
	//@URL : http://localhost:8080/spring-mvc/test/request-param-demo?id=12
	@RequestMapping("/request-param-demo")
	public String requestParamDemo(@RequestParam(required = false, defaultValue = "1") Integer id, Model model) {
		model.addAttribute("reqParam", id);
		return "reqParamDemo";
	}
	
//	@RequestMapping("/request-param-demo")
//	public String requestParamDemo(@RequestParam(name="user_id", required = false, 
//				defaultValue = "1") Integer id, Model model) {
//		model.addAttribute("reqParam", id);
//		return "reqParamDemo";
//	}
	
	
	//@URL : http://localhost:8080/spring-mvc/test/map-all-params-demo?test1=toto&test2=titi
	@RequestMapping("/map-all-params-demo")
	public String mapAllParamsDemo(@RequestParam Map<String, String> allParams, Model model) {
		String allValuesCommaSeparated = allParams.entrySet().stream()
			.map(entry -> entry.getValue())
			.collect(Collectors.joining(","));
		model.addAttribute("allValues", allValuesCommaSeparated);
		return "mapAllParamsDemo";
	}
	
	
	
	//@URL : http://localhost:8080/spring-mvc/test/multi-value-param-demo?ids=1,2,3,4
	@RequestMapping("/multi-value-param-demo")
	public String multiValueParamDemo(@RequestParam List<String> ids, Model model) {
		String allValuesCommaSeparated = ids.stream()
				.collect(Collectors.joining(","));
		model.addAttribute("allValues", allValuesCommaSeparated);
		return "mapAllParamsDemo";
	}
	
	
	//@URL : http://localhost:8080/spring-mvc/test/path-variable-demo/13
	@RequestMapping("/path-variable-demo/{id}")
	public String pathVarDemo(@PathVariable(required=false) Integer id, Model model) {
		model.addAttribute("pathVar", id);
		return "pathVarDemo";
	}
	
	//The same as the previous one , but it gives chance to rename the value of parameter as variable 
//	@RequestMapping("/path-variable-demo/{user_id}")
//	public String pathVarDemo(@PathVariable(name="user_id", required=false) int id, Model model) {
//		model.addAttribute("pathVar", id);
//		return "pathVarDemo";
//	}
	
	
	//@URL : http://localhost:8080/spring-mvc/test/get-mapping-demo
	@GetMapping("/get-mapping-demo")
	public String getMappingDemo() {
		return "getMappingDemo";
	}
	
//	@RequestMapping(value = "/get-mapping-demo", method = RequestMethod.GET)
//	public String getMappingDemo() {
//		return "getMappingDemo";
//	}
	
	

}