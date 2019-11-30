package com.hk.healthcare.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginService implements ILoginService {
	
	@Autowired
	private ILoginDao ilogindao;
	
	@Override
	public boolean Login(String id, String password) {
		
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
	
}
