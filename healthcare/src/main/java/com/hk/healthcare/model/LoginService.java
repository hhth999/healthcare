package com.hk.healthcare.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.healthcare.dto.MemberDto;

@Repository
public class LoginService implements ILoginService {
	
	@Autowired
	private ILoginDao ilogindao;
	
	@Override
	public MemberDto Login(String id, String password) {
		return ilogindao.Login(id, password);
	}
	
	@Override
	public void loginFail(String id, String password) {
		ilogindao.loginFail(id, password);
	}
	@Override
	public int failNum(String id, String password) {
		// TODO Auto-generated method stub
		return ilogindao.failNum(id, password);
	}
	@Override
	public boolean failGetID(String id) {
		// TODO Auto-generated method stub
		return ilogindao.failGetID(id);
	}
	@Override
	public void clearFailNum(String id, String password) {
		// TODO Auto-generated method stub
		ilogindao.clearFailNum(id, password);
	}
	
	@Override
	public boolean checkIdEmail(String id, String email) {
		// TODO Auto-generated method stub
		return ilogindao.checkIdEmail(id, email);
	}
	
	@Override
	public void passClear(String id, String email, StringBuffer password) {
		// TODO Auto-generated method stub
		ilogindao.passClear(id, email, password);
	}
	
	
	
} //클래스 끝
