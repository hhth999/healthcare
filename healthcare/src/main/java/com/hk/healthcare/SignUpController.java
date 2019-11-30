package com.hk.healthcare;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.hk.healthcare.dto.MemberDto;
import com.hk.healthcare.model.LoginService;
import com.hk.healthcare.model.SignUpService;
import com.sun.mail.iap.Response;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SignUpController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Autowired
	private SignUpService SignUpService;
	
	
	@RequestMapping(value = "MemberIdCheckAction.do", method = RequestMethod.POST ,produces = "application/text; charset=utf8")
	@ResponseBody
	public String Check(HttpServletResponse response,HttpServletRequest request,Locale locale, Model model, String id) throws UnsupportedEncodingException {
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		boolean check = SignUpService.SignUpCheck(id);
		System.out.println("check : " + check);
		String result = "";
		if (check) {
			result = "";
		} else if (!check) {
			result = "사용가능한 아이디입니다.";
		}
		
		System.out.println(result);
		model.addAttribute(result);
		return result;
	}
	
	@RequestMapping(value = "MemberJoinAction.do", method = RequestMethod.POST)
	public String SignUp(Locale locale, Model model, MemberDto member) {
		System.out.println("Controller");
		SignUpService.SignUp(member);
		
		
		return "Main";
	}
	
	
	
}


