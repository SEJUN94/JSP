package com.jsp.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.dao.PdsDAO;
import com.jsp.dao.ReplyDAO;
import com.jsp.dto.PdsVO;

public class PdsServiceImpl implements PdsService {
	
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	private PdsDAO pdsDAO;
	public void setPdsDAO(PdsDAO pdsDAO) {
		this.pdsDAO = pdsDAO;
	}
	
	private ReplyDAO replyDAO;
	public void setReplyDAO(ReplyDAO replyDAO) {
		this.replyDAO = replyDAO;
	}
	
	@Override
	public Map<String, Object> getPdsList(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			
			Map<String, Object> dataMap = new HashMap<String, Object>();
			
			// 현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.
			List<PdsVO> pdsList = pdsDAO.selectPdsCriteria(session, cri);
			
			// reply count 입력
			for (PdsVO pds : pdsList) {
				int replycnt = replyDAO.countReply(session, pds.getPno());
				pds.setReplycnt(replycnt);
			}
			
			// 전체 psd 개수
			int totalCount = pdsDAO.selectPdsCriteriaTotalCount(session, cri);
			
			// PageMaker 생성.
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(totalCount);
			
			dataMap.put("pdsList", pdsList);
			dataMap.put("pageMaker", pageMaker);
			
			return dataMap;
			
		}finally {
		session.close();
		}
	}

	@Override
	public PdsVO getPds(int pno) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PdsVO getPdsForModify(int pno) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void regist(PdsVO pds) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(PdsVO pds) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(int pno) throws SQLException {
		// TODO Auto-generated method stub

	}

}
