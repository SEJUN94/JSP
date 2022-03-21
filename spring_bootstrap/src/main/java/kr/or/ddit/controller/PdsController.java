package kr.or.ddit.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jsp.command.Criteria;
import com.jsp.dto.AttachVO;
import com.jsp.dto.PdsVO;
import com.jsp.service.PdsService;
import com.jsp.util.MakeFileName;

import kr.or.ddit.command.PdsRegistCommand;

@Controller
@RequestMapping("/pds")
public class PdsController {

	@Resource(name="pdsService")
	private PdsService service;	
	
	@RequestMapping("/main")
	public void main() throws Exception {}
	
	@RequestMapping("/list")
	public ModelAndView list(Criteria cri, ModelAndView mnv) throws Exception {
		String url = "pds/list";

		Map<String, Object> dataMap = service.getList(cri);

		mnv.addObject("dataMap", dataMap);
		mnv.setViewName(url);

		return mnv;
	}
	
	@RequestMapping("/registForm")
	public String registForm() throws Exception {
		String url = "pds/regist";
		return url;
	}
	
	@Resource(name = "fileUploadPath")
	private String fileUploadPath;
	
	@RequestMapping(value = "/regist", method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
	public String regist(PdsRegistCommand registReq,HttpServletRequest request,
						 RedirectAttributes rttr) throws Exception {
		String url = "redirect:/pds/list.do";
		

		PdsVO pds = registReq.toPdsVO();
		
		
		List<AttachVO> attachList = new ArrayList<AttachVO>();
			
		String savePath = this.fileUploadPath;
		
		List<MultipartFile> multiFiles = registReq.getUploadFile();		
		if(multiFiles!=null)for(MultipartFile multi : multiFiles) {

			String fileName = MakeFileName.toUUIDFileName(multi.getOriginalFilename(), "$$");
			File file = new File(savePath,fileName);
			
			multi.transferTo(file);
			
			AttachVO attach = new AttachVO();
			attach.setFileName(fileName);
			attach.setFileType(fileName.substring(fileName.lastIndexOf(".")+1));
			attach.setUploadPath(savePath);
			
			attachList.add(attach);
		}		
				
		pds.setAttachList(attachList);
		pds.setTitle((String)request.getAttribute("XSStitle"));
		
		service.regist(pds);
		
		rttr.addFlashAttribute("from", "regist");
		return url;
	}
	
	
	@RequestMapping("/detail")
	public ModelAndView detail(int pno, String from, ModelAndView mnv) throws Exception {
		String url = "pds/detail";

		PdsVO pds = null;
		if (from != null && from.equals("list")) {
			pds = service.read(pno);
			url = "redirect:/pds/detail.do?pno=" + pno;
		} else {
			pds = service.getPds(pno);
		}

		mnv.addObject("pds", pds);
		mnv.setViewName(url);

		return mnv;
	}
	
	@RequestMapping("/modifyForm")
	public ModelAndView modifyForm(ModelAndView mnv, int pno) throws Exception {
		String url = "pds/modify";

		PdsVO pds = service.getPds(pno);
		

		mnv.addObject("pds", pds);
		mnv.setViewName(url);

		return mnv;
	}
	

	@RequestMapping("/modify")
	public String modifyPOST(PdsVO pds, 
							 HttpServletRequest request, 
							 RedirectAttributes rttr) throws Exception {
		String url = "redirect:/pds/detail.do";
		
		
		// DB 저장
		service.modify(pds);
		
		rttr.addFlashAttribute("from", "modify");
		rttr.addAttribute("pno", pds.getPno());
		return url;
	}
	
	@RequestMapping("/remove")
	public String remove(int pno, RedirectAttributes rttr) throws Exception {
		String url = "redirect:/pds/detail.do";
		
		// DB삭제
		service.remove(pno);

		rttr.addFlashAttribute("from", "remove");
		rttr.addAttribute("pno", pno);
		
		return url;
	}
	
	
	
}
