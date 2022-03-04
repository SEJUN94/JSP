package com.jsp.action.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.josephoconnell.html.HTMLInputFilter;
import com.jsp.action.Action;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.controller.XSSHttpRequestParameterAdapter;
import com.jsp.controller.XSSResolver;
import com.jsp.dto.NoticeVO;
import com.jsp.service.NoticeService;

public class NoticeRegistAction implements Action {

	private NoticeService noticeService;
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) 
																	throws Exception {
		String url="/notice/regist_success";
		
		NoticeVO notice = (NoticeVO)XSSHttpRequestParameterAdapter.execute(request, NoticeVO.class,true);
		
		/*
		NoticeVO notice = (NoticeVO)HttpRequestParameterAdapter.execute(request, NoticeVO.class);
		
		XSSResolver.paraseXSS(request);
		
		//notice.setTitle(HTMLInputFilter.htmlSpecialChars(notice.getTitle()));
		//notice.setContent(HTMLInputFilter.htmlSpecialChars(notice.getContent()));
		notice.setTitle((String)request.getAttribute("XSStitle"));
		notice.setContent((String)request.getAttribute("XSScontent"));
		*/
		
		noticeService.regist(notice);
			
		return url;
	}

}
