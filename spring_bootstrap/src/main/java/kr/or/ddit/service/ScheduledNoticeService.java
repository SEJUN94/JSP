
package kr.or.ddit.service;

import java.sql.SQLException;

import com.jsp.dto.NoticeVO;
import com.jsp.service.NoticeService;

public interface ScheduledNoticeService extends NoticeService{

	public NoticeVO getNoticeByImage(String imageFile)throws SQLException;
}
