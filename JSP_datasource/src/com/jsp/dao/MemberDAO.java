package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.MemberVO;

public interface MemberDAO {
	
	//회원리스트 조회
	List<MemberVO> selectMemberList(SqlSession session)throws SQLException;
	
	//해당회원 조회
	MemberVO getMember(SqlSession session,String id) throws SQLException;
	
	/**
	 * @param mv를 이용하여 회원정보를 DB에 넣어주는 메서드
	 * @return 회원가입 성공시 1반환 실패시 0반환
	 * @throws SQLException
	 */
	//회원가입
	int insertMember(SqlSession session,MemberVO mv) throws SQLException;
	
	/**
	 * @param mv를 이용하여 해당 회원의 정보를 수정하는 메서드
	 * @return 정보수정 성공시 1반환 실패시 0반환
	 * @throws SQLException
	 */
	//개인정보 수정
	int updateMember(SqlSession session,MemberVO mv) throws SQLException;
	
	
	/**
	 * @param id을 이용하여 해당 회원을 삭제하는 메서드
	 * @return 회원탈퇴 성공시 1반환 실패시 0반환
	 * @throws SQLException
	 */
	//회원탈퇴
	int deleteMember(SqlSession session,String id) throws SQLException;
}
