package com.a2m.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CreateController{
	
	@GetMapping("/CreateUser")
	public ModelAndView CreatePage() {
		ModelAndView mav = new ModelAndView("CreateUser");
		return mav;
	}
	
}