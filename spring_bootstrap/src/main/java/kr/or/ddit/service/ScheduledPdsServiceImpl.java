package kr.or.ddit.service;

import java.sql.SQLException;

import com.jsp.dto.PdsVO;

import kr.or.ddit.dao.PdsDAOBean;

public class ScheduledPdsServiceImpl extends PdsServiceImpl implements ScheduledPdsService {

	private PdsDAOBean pdsDAOBeanChild;
	public void setPdsDAOBeanChild(PdsDAOBean pdsDAOBeanChild) {
		this.pdsDAOBeanChild = pdsDAOBeanChild;
	}
	
	@Override
	public PdsVO getPdsByImage(String imageFile) throws SQLException {
		PdsVO pds = pdsDAOBeanChild.selectPdsByImage(imageFile);
		return pds;
	}

}
