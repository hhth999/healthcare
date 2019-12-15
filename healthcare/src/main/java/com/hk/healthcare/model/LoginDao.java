package com.hk.healthcare.model;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.healthcare.dto.MemberDto;

@Repository
public class LoginDao implements ILoginDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	private String namespace = "com.hk.healthcare.login.";

	// 로그인
	@Override
	public MemberDto Login(String id, String password) {
		int count = 0;
		Map<String, String> map = new HashMap<String, String>();
		
		System.out.println("Dao에서의 email, password" + id + "" + password);
		map.put("id", id);
		map.put("password", password);
		System.out.println(map);

		// System.out.println("One" + sqlSession.selectOne(namespace + "login", map));
		// count = sqlSession.selectOne(namespace + "login", map);

		if (sqlSession.selectOne(namespace + "login", map) == null) {
			return null;
		} else {
			MemberDto member = sqlSession.selectOne(namespace + "login", map);
			return member;
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
	//로그인 실패시 아이디가 있는지 확인한 후에 failnum을 증가시키기 위함.
	@Override
	public boolean failGetID(String id) {
		int get = sqlSession.selectOne(namespace + "getFailId", id ); 
		
		if(get == 0 ) {
			return false;
		} else {
			return true;
		}

	}
	
	//로그인 성공시 FailNum 0으로 초기화
	@Override
	public void clearFailNum(String id, String password) {
		// TODO Auto-generated method stub
		Map map = new HashMap<String, String>();
		map.put("id", id);
		map.put("password", password);
		
		sqlSession.update(namespace + "clearFailNum", map);
	}
	
	@Override
	public boolean checkIdEmail(String id, String email) {
		// TODO Auto-generated method stub
		Map map = new HashMap<String, String>();
		
		map.put("id", id);
		map.put("email", email);
		int count = sqlSession.selectOne(namespace + "checkEmailId", map);
		
		if(count == 0) {
			return false;
		} else {
			return true;
		}
		
		
	}
	//비밀번호 찾기 시 비밀번호 재설정
	@Override
	public void passClear(String id, String email, StringBuffer password) {

	 Map map = new HashMap<String, String>();
	 String password2 = password.toString();
	 
	 map.put("id", id);
	 map.put("email", email);
	 map.put("password", password2);
		
	 sqlSession.update(namespace + "passClear", map);
	 
	}

} // Class 끝
