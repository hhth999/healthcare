package com.hk.healthcare.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.healthcare.dto.FreeboardDto;

@Service
public class FboardService implements IFboardService {
	@Autowired
	private IFboardDao ifboarddao;
	
	@Override
public List<FreeboardDto> getAllList() {
	// TODO Auto-generated method stub
	return ifboarddao.getAllList();
}
}
