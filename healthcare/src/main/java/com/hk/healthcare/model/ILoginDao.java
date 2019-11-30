package com.hk.healthcare.model;

public interface ILoginDao {
	public boolean Login(String email, String password);
	public void loginFail(String id, String password);
	public int failNum(String id, String password);
}
