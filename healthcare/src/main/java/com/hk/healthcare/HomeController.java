package com.hk.healthcare;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.hk.healthcare.model.LoginService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Autowired
	private LoginService loginService;
	
	
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
		//로그인 컨트롤러
		@RequestMapping(value = "login.do")
		public void Login(HttpServletRequest request,HttpServletResponse response,Locale locale, Model model, String id, String password) throws IOException {
			
		boolean isS = loginService.Login(id, password);
		System.out.println(id + "" + password);
		HttpSession session = request.getSession();
		HashMap status = new HashMap();
		
		
		
		if (isS) { 
			status.put("status", 404);
		    session.setAttribute("loginId", id);

		} else {
		    status.put("status", 200); 
		}
		

		String json = new Gson().toJson(status);
		response.getWriter().write(json);

		System.out.println("Ajax 컨트롤러 요청 : " + json);

		
		}
		
		@RequestMapping(value = "/logOut.do", method = RequestMethod.GET)
		public String logOut(HttpServletRequest request,HttpServletResponse response,Locale locale, Model model, String email, String password) {
			logger.info("로그아웃으로 이동 {}.", locale);
			HttpSession session = request.getSession();
			
			session.removeAttribute("loginId");
			
			return "redirect:home.do";
		}
}


