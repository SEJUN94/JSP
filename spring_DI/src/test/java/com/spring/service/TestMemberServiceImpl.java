package com.spring.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jsp.command.Criteria;
import com.jsp.dto.MemberVO;
import com.jsp.service.SearchMemberService;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/spring/context/root-context.xml")
public class TestMemberServiceImpl {
	
	// @Autowired  type 비교 만약 type(타입)이 딱 하나라면 가능할거임
	@Resource(name = "searchMemberService") //bean id로 비교
	SearchMemberService memberService;
	
	@Test
	public void testGetList() throws Exception{
		Criteria cri = new Criteria();
		
		List<MemberVO> memberList
			= (List<MemberVO>) memberService.getSearchMemberList(cri).get("memberList");
		
		Assert.assertEquals(10, memberList.size());
	}
}
