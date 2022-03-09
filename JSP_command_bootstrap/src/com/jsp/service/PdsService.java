package com.jsp.service;

import java.sql.SQLException;
import java.util.Map;

import com.jsp.command.Criteria;
import com.jsp.dto.PdsVO;

public interface PdsService {
	// 목록조회	
	Map<String,Object> getPdsList(Criteria cri)throws SQLException;
	
	// 상세보기
	PdsVO getPds(int pno)throws SQLException;	
	PdsVO getPdsForModify(int pno)throws SQLException;
		
	// 등록
	void regist(PdsVO pds)throws SQLException;
		
	// 수정
	void modify(PdsVO pds)throws SQLException;
	
	// 삭제
	void remove(int pno)throws SQLException;
}
