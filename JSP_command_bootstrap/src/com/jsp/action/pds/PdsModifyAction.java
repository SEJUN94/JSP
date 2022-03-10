package com.jsp.action.pds;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.PdsVO;
import com.jsp.service.PdsService;

public class PdsModifyAction implements Action {

	private PdsService pdsService;

	public void setPdsService(PdsService pdsService) {
		this.pdsService = pdsService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String url = "/pds/modify_success";
		try {
			PdsVO pds = null;//modifyAttaches(request, response);
			pdsService.modify(pds);

			request.setAttribute("pds", pds);
	
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			url = null;
			e.printStackTrace();
		}

		return url;
	}
	
	
}







