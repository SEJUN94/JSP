package com.jsp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.dao.NoticeDAO;
import com.jsp.dto.MemberVO;

public class SearchNoticeServiceImpl extends NoticeServiceImpl
									 implements SearchNoticeService {

	@Override
	public Map<String, Object> getSearchNoticeList(Criteria cri) throws Exception {
		Map<String,Object>dataMap = null;
		
		SqlSession session = SqlSessionFactory.openSession();
		
		try {
			List<MemberVO>memberList = NoticeDAO.selectSearchNoticeList(session, cri);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(NoticeDAO.selectSearchNoticeList(session, cri));
			
			dataMap = new HashMap<String, Object>();
			dataMap.put("memberList", memberList);
			dataMap.put("pageMaker", pageMaker);
					
		} finally {
			session.close();
		}
		return dataMap;
	}
}
