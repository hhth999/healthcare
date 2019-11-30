package com.hk.healthcare.model;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao implements ILoginDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	private String namespace = "com.hk.healthcare.login.";

	// 로그인
	@Override
	public boolean Login(String id, String password) {
		int count = 0;
		Map<String, String> map = new HashMap<String, String>();

		System.out.println("Dao에서의 email, password" + id + "" + password);
		map.put("id", id);
		map.put("password", password);
		System.out.println(map);

		// System.out.println("One" + sqlSession.selectOne(namespace + "login", map));
		// count = sqlSession.selectOne(namespace + "login", map);

		if (sqlSession.selectOne(namespace + "login", map) == null) {
			return false;
		} else {
			return true;
		}

	}

	// 로그인 실패시 DB Failnum 1 증가
	@Override
	public void loginFail(String id, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("password", password);
		sqlSession.update(namespace + "failLogin", map);
	}

	// 로그인 실패 카운트
	@Override
	public int failNum(String id, String password) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("password", password);
		int failNum = sqlSession.selectOne(namespace + "failNum", map);
		System.out.println("dao failNum : " + failNum);
		
		return failNum;
	}

} // Class 끝
