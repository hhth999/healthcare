package com.hk.healthcare.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.healthcare.dto.MemberDto;

@Repository
public class SignUpDao implements ISignUpDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "com.hn.board.";
	
	
	@Override
	public boolean SignUpCheck(String id) {
		int check = sqlSession.selectOne(namespace + "checkDuplication", id);
		boolean result = false;
		
		if(check > 0 ) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	
	@Override
	public boolean SignUp(MemberDto member) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			sqlSession.insert(namespace + "signUp", member);
			result = true;
		} catch (Exception e) {
			result = false;
		}
		
		return result;
	}
}
