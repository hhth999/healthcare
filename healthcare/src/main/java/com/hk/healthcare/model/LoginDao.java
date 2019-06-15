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
	
 @Override
public boolean Login(String email, String password) {
	 int count = 0;
	 Map<String,String> map = new HashMap<String,String>();
	 
	 System.out.println("Dao에서의 email, password" + email + "" + password);
	 map.put("email", email);
	 map.put("password", password);
	 System.out.println(map);
	 
//	 System.out.println("One" + sqlSession.selectOne(namespace + "login", map));
//	 count = sqlSession.selectOne(namespace + "login", map);
	 
	 if(sqlSession.selectOne(namespace + "login", map) == null) {
			return false;
		} else {
			return true;
		}
		
	 
	
	
	
}
}
