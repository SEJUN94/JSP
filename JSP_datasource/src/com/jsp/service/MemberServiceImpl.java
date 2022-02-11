package com.jsp.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.dao.MemberDAO;
import com.jsp.dto.MemberVO;

public class MemberServiceImpl implements MemberService {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public List<MemberVO> getMemberList() throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			List<MemberVO> memberList = memberDAO.selectMemberList(session);
			return memberList;
		}finally {
			session.close();
		}
	}
	
	@Override
	public MemberVO getMember(String id) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession(false);
		
		MemberVO member = null;
		try {
			member = memberDAO.getMember(session,id);
		}finally {
			session.close();
		}
		return member;
	}

	@Override
	public int insertMember(MemberVO mv) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		int cnt;
		try {
			cnt = memberDAO.insertMember(session, mv);
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO mv) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		int cnt;
		try {
			cnt = memberDAO.updateMember(session, mv);
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String id) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		int cnt;
		try {
			cnt = memberDAO.deleteMember(session, id);
		}finally {
			session.close();
		}
		return cnt;
	}
}
