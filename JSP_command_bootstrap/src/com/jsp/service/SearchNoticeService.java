package com.jsp.service;

import java.util.Map;

import com.jsp.command.Criteria;

public interface SearchNoticeService extends MemberService {

	Map<String,Object>getSearchNoticeList(Criteria cri) throws Exception;
	
	
}
