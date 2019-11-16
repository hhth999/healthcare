package com.hk.healthcare.model;

import com.hk.healthcare.dto.MemberDto;

public interface ISignUpService {
	public boolean SignUpCheck(String id);
	public boolean SignUp(MemberDto member);
}
