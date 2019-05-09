package com.hk.healthcare;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	
		return "Main";
	}
	
	// 계정생성 창으로 이동
		@RequestMapping(value = "/signUpPage.do", method = RequestMethod.GET)
		public String signUpPage(Locale locale) {
			logger.info("계정생성 창으로 이동 {}.", locale);
			return "signUp";
		}
		
		//id 중복체크 란 이동
		@RequestMapping(value = "/IdCheckForm.do", method = RequestMethod.GET)
		public String IdCheckForm(Locale locale) {
			logger.info("계정생성 창으로 이동 {}.", locale);
			return "IdCheckForm";
		}
}
