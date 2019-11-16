package com.hk.healthcare.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.healthcare.dto.MemberDto;

@Service
public class SignUpService implements ISignUpService {

	@Autowired
	private ISignUpDao signupdao;
	
	@Override
public boolean SignUpCheck(String id) {	
	return signupdao.SignUpCheck(id);
}

	@Override
	public boolean SignUp(MemberDto member) {
		// TODO Auto-generated method stub
		return signupdao.SignUp(member);
	}
}
