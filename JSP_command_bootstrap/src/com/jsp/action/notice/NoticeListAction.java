package com.jsp.action.notice;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.Criteria;
import com.jsp.service.NoticeService;

public class NoticeListAction implements Action {

	private NoticeService noticeService;
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@Override
	public String process(HttpServletRequest requeset, HttpServletResponse response) throws Exception {

		String url = "notice/list";

		String pageParam = requeset.getParameter("page");
		String perPageNumParam = requeset.getParameter("perPageNum");
		String serchTypeParam = requeset.getParameter("searchType");
		String keywordParam = requeset.getParameter("keyword");
		
		Criteria cri = new Criteria();
		cri.setSearchType(serchTypeParam);
		cri.setKeyword(keywordParam);
		
		
		try { // 페이지번호 외(ex_공백 등)의 내용이 들어올 경우 에러 방지
			if(pageParam != null && !pageParam.isEmpty()) cri.setPage(Integer.parseInt(pageParam));
			if(perPageNumParam != null && !perPageNumParam.isEmpty())cri.setPerPageNum(Integer.parseInt(perPageNumParam));
		} catch (Exception e) {
			response.sendError(response.SC_BAD_REQUEST);//400에러 내보냄
			return null; // 이름이 없기때문에 서블릿이 아무것도 하지 않음
		}
		
		

		requeset.setAttribute("cri", cri);
		
		try {
			
			Map<String, Object> noticeList = noticeService.getNoticeList(cri);
			requeset.setAttribute("noticeList", noticeList);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return url;
	}
}
