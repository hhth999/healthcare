package com.hk.healthcare.model;

import com.hk.healthcare.dto.MemberDto;

public interface ILoginService {
	public MemberDto Login(String id, String password);
	public void loginFail(String id, String password);
	public int failNum(String id, String password);
	public boolean failGetID(String id);
}
