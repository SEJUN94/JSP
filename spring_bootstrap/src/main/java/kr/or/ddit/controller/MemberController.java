package kr.or.ddit.controller;

import java.io.File;
import java.sql.SQLException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.command.Criteria;
import com.jsp.service.LoginSearchMemberService;
import com.jsp.util.MakeFileName;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private LoginSearchMemberService memberService;
	
	@RequestMapping("/main")
	public void main() {}
	
	@RequestMapping("/list")
	public ModelAndView list(Criteria cri, HttpServletRequest request, ModelAndView mnv) throws SQLException{
		
		String url = "member/list";
		
		Map<String,Object> dataMap = null;
		
		try {
			dataMap = memberService.getSearchMemberList(cri);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		mnv.addObject("dataMap",dataMap);  // Map자체를 통째로 넣어줌
		//mnv.addAllObjects(dataMap);	// key value 값을 하나씩 꺼내서 넣어줌
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping(value="/registForm")
	public String registForm() {
		String url = "member/regist";
		return url;
	}
	
	@Resource(name = "picturePath")
	private String picturePath;
	
	@RequestMapping(value = "/picture", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	@ResponseBody
	public ResponseEntity<String> picture(@RequestParam("pictureFile") MultipartFile multi, String oldPicture) throws Exception{
		
		ResponseEntity<String> entity = null;
		
		String result = "";
		HttpStatus status = null;
		
		/* 파일저장확인 */
		if((result = savePicture(oldPicture, multi)) == null) {
			result = "업로드 실패했습니다!";
			status = HttpStatus.BAD_REQUEST;
			
		} else {
			status = HttpStatus.OK;
		}
		
		entity = new ResponseEntity<String>(result, status);
		
		return entity;
	}

	private String savePicture(String oldPicture, MultipartFile multi) throws Exception {
		String fileName = null;
		
		/* 파일유무확인 */
		if(!(multi == null || multi.isEmpty() || multi.getSize() > 1024 * 1024 * 5)) {
			/* 파일저장폴더설정 */
			String uploadPath = picturePath;
			fileName = MakeFileName.toUUIDFileName(multi.getOriginalFilename(), "$$");
			File storeFile = new File(uploadPath, fileName);
			
			storeFile.mkdirs();
			
			// local HDD에 저장.
			multi.transferTo(storeFile);
			
			if(oldPicture != null && !oldPicture.isEmpty()) {
				File oldFile = new File(uploadPath, oldPicture);
				if(oldFile.exists()) {
					oldFile.delete();
				}
			}
		}
		
		return fileName;
	}
	
}
