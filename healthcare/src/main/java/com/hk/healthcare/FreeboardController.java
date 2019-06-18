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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

/**
 * Handles requests for the application home page.
 */
@Controller
public class FreeboardController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws IOException 
	 */
	@RequestMapping(value = "fboardlist.do")
	public void list(HttpServletRequest request,HttpServletResponse response,Locale locale, Model model) throws IOException {
	    HttpSession session = request.getSession();
	    String loginId = (String) session.getAttribute("loginId");
	    boolean isS;
	    
		System.out.println("로그인한 아이디 자유게시판 " + loginId);
		if(loginId == null || loginId == ""	) {
			isS = false;
			
		} else {
			isS = true;
		}
		
		
		HashMap status = new HashMap();

		if (isS) { 
			status.put("status", 404);
		   

		} else {
		    status.put("status", 200); 
		}
		

		String json = new Gson().toJson(status);
		response.getWriter().write(json);
	}
	@RequestMapping(value = "goFboard.do")
	public String goFboard(HttpServletRequest request,HttpServletResponse response,Locale locale, Model model) throws IOException {
	
		return "Fboardlist";
		
	}

	
	
	
	
	}

