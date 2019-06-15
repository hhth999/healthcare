package com.hk.healthcare.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginService implements ILoginService {
	
	@Autowired
	private ILoginDao ilogindao;
	
	@Override
	public boolean Login(String email, String password) {
		
		return ilogindao.Login(email, password);
	}
	
}
