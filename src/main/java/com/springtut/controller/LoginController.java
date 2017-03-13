package com.springtut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String init(ModelMap map) {
		return "login";
	}
}
