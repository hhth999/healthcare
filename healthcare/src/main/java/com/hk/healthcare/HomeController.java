package com.hk.healthcare;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.hk.healthcare.dto.MemberDto;
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
	@Autowired
	private JavaMailSender mailSender;
	
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
		
		//로그인 실패시 결과값이 널값인지 체크하기 위함.	
		boolean idNullCheck = loginService.failGetID(id);
		
		//로그인
		boolean isS = false;
		MemberDto member = loginService.Login(id, password);
		
		if(member == null) {
			isS = false;
		} else {
			isS = true;
		}
		
		//로그인 실패시 결과값이 널값인지 체크하기 위함.		
		
		
		HttpSession session = request.getSession();
		HashMap status = new HashMap();
		
		
		if (isS) { 
			status.put("status", 404);
			loginService.clearFailNum(id, password);
		    session.setAttribute("loginId", id);

		} else {
			if(idNullCheck) {
				loginService.loginFail(id, password);
				int failNum = loginService.failNum(id, password);
				status.put("failnum", failNum);
			}
		    status.put("status", 200); 
		}
		
		if(idNullCheck) {
			if(loginService.failNum(id, password) >= 5) {
				status.put("status", 303);
				String json = new Gson().toJson(status);
				response.getWriter().write(json);
				return;				
			}
		}

		String json = new Gson().toJson(status);
		response.getWriter().write(json);


		
		}
		
		@RequestMapping(value = "/logOut.do", method = RequestMethod.GET)
		public String logOut(HttpServletRequest request,HttpServletResponse response,Locale locale, Model model, String email, String password) {
			logger.info("로그아웃으로 이동 {}.", locale);
			HttpSession session = request.getSession();
			
			session.removeAttribute("loginId");
			
			return "redirect:home.do";
		}
		
		@RequestMapping(value = "/getPassword.do", method = RequestMethod.GET)
		public String getPassword(HttpServletRequest request,HttpServletResponse response,Locale locale, Model model) {
			logger.info("비밀번호 찾기화면 이동 {}.", locale);
			
			
			return "/login/password/getPassword";
		}
		
		@RequestMapping(value = "/nextGetPassword.do", method = RequestMethod.GET)
		public String nextGetPassword(HttpServletRequest request,HttpServletResponse response,Locale locale, Model model) {
			logger.info("비밀번호 찾기 다음화면으로 이동 {}.", locale);
			
			
			return "/login/password/nextGetPassword";
		}
		
		@RequestMapping(value = "/checkIdEmail.do", method = RequestMethod.POST)
		public @ResponseBody void checkIdEmail(HttpServletRequest request,HttpServletResponse response,Locale locale, Model model,String email, String id) throws IOException {
			logger.info("비밀번호 찾기 다음화면으로 이동 {}.", locale);
			
			boolean check = loginService.checkIdEmail(id, email);
			HashMap status = new HashMap();

			if(check) {
				status.put("status", "checksuccess");
			} else {
				status.put("status", "checkfail");
			}
			
			String json = new Gson().toJson(status);
			response.getWriter().write(json);

			
		}
		
		@RequestMapping(value = "/passClearAndSendEmail.do", method = RequestMethod.GET)
		public @ResponseBody void passClearAndSendEmail(HttpServletRequest request,HttpServletResponse response,Locale locale, Model model,String email, String id) throws IOException {
			logger.info("비밀번호 찾기 다음화면으로 이동 {}.", locale);
			
			StringBuffer password = new StringBuffer();
			Random rnd = new Random();
			for (int i = 0; i < 20; i++) {
			    int rIndex = rnd.nextInt(3);
			    switch (rIndex) {
			    case 0:
			        // a-z
			        password.append((char) ((int) (rnd.nextInt(26)) + 97));
			        break;
			    case 1:
			        // A-Z
			        password.append((char) ((int) (rnd.nextInt(26)) + 65));
			        break;
			    case 2:
			        // 0-9
			        password.append((rnd.nextInt(10)));
			        break;
			    }
			}
			
			try {
				loginService.passClear(id, email, password);	
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			 String setfrom = "formailtestdev@gmail.com";         
			    String tomail  = "hhth999@gmail.com";     // 받는 사람 이메일
			    String title   = "(HealthCare) 비밀번호 재설정 메일입니다.";      // 제목
			    String content = "냉무";    // 내용
			   
			    try {
			      System.out.println("메일보내기전");
			      MimeMessage message = mailSender.createMimeMessage();
			      MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			 
			      messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
			      messageHelper.setTo(tomail);     // 받는사람 이메일
			      messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
			      messageHelper.setText(content);  // 메일 내용
			     
			      mailSender.send(message);
			    } catch(Exception e){
			      System.out.println(e);
			    }
			System.out.println("메일 보내고2");
			HashMap status = new HashMap();

			
			
			String json = new Gson().toJson(status);
			response.getWriter().write(json);

			
		}
		
		@RequestMapping(value = "/nextGetPassword.do", method = RequestMethod.POST)
		public String nextPassword(HttpServletRequest request,HttpServletResponse response,Locale locale, Model model) {
			logger.info("로그아웃으로 이동 {}.", locale);
			
			return "login/password/nextGetPassword";
		}
		
		
		
} //클래스 끝


