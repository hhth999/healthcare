package com.hk.healthcare.model;

public interface ILoginService {
	public boolean Login(String id, String password);
	public void loginFail(String id, String password);
	public int failNum(String id, String password);
}
