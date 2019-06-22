package com.hk.healthcare.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.healthcare.dto.FreeboardDto;

@Repository
public class FboardDao implements IFboardDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "com.hk.healthcare.fboard.";
	
	@Override
public List<FreeboardDto> getAllList() {
	// TODO Auto-generated method stub
		
		
	return sqlSession.selectList(namespace + "getAlllist");
}
}
