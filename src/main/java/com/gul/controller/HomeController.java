package com.gul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gul.thread.EmailThreading;

@Controller
public class HomeController {

	@Autowired
	JavaMailSender mailSender;

	@GetMapping("/")
	public ModelAndView view() {
		ModelAndView mav = new ModelAndView("home");

		EmailThreading threading = new EmailThreading(mailSender, "gulfarooqui09@gmail.com", "Welcome",
				"This is sent form Java Mail","Test Message");
		threading.start();
		return mav;
	}
}
