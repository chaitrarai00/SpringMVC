package com.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.User;
/*
 * We do request processing and manipulation in controllers
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("home Page requested,locale: "+locale);
		Date date=new Date();
		DateFormat dateformat=DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,locale);
		String formatteddate=dateformat.format(date);
		model.addAttribute("serverTime",formatteddate);// attribute can be accessed to view
		return "home";
	}
	
	@RequestMapping(value="/user", method = RequestMethod.POST)
	public String user(@Validated User user, Model model) {
		System.out.println("UserPage requested");
		model.addAttribute("userName",user.getUsername());
		return "user";
	}
}
