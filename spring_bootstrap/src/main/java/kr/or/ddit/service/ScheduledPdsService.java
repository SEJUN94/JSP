package kr.or.ddit.service;

import java.sql.SQLException;

import com.jsp.dto.PdsVO;
import com.jsp.service.PdsService;

public interface ScheduledPdsService extends PdsService {
	
	public PdsVO getPdsByImage(String imageFile)throws SQLException;
}
