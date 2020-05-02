package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.spring.dao.MemberDAO;
import com.spring.dto.MemberVO;
import com.spring.exception.InvalidPasswordException;
import com.spring.exception.NotFoundIDException;
import com.spring.request.SearchCriteria;
import com.spring.service.MemberServiceImpl;

public class TestMemberServiceImpl {

	private MemberDAO memberDAO =new MockMemberDAO();
	
	private MemberServiceImpl service;
	
	@Before
	public void init(){
		service = new MemberServiceImpl();
		service.setMemberDAO(new MockMemberDAO());		
	}
	
	
	@Test
	public void testGetList()throws SQLException{
		
		List<MemberVO> memberList = service.getMemberList();
		
		Assert.assertEquals(3,memberList.size());
	}
	
	@Test
	public void testGetSearchList()throws SQLException{
		
		SearchCriteria cri = new SearchCriteria();
		cri.setKeyword("mimi");
		cri.setSearchType("i");
		
		List<MemberVO> memberList = 
				(List<MemberVO>)service.getMemberList(cri).get("memberList");
		
		Assert.assertEquals(2,memberList.size());
	}
	@Test
	public void testLogin()throws Exception{
		String testID = "kkk";
		String testPWD ="kkk";
		
		try{
			service.login(testID, testPWD);
		}catch(NotFoundIDException e){
			Assert.assertEquals(1,1);
		}catch(InvalidPasswordException e){
			Assert.assertEquals(1,0);
		}
		
		testID="mimi";
		try{
			service.login(testID,testPWD);
		}catch(InvalidPasswordException e){
			Assert.assertEquals(1,1);
		}catch(NotFoundIDException e){
			Assert.assertEquals(1,2);
		}
		
		testPWD="mimi";
		try{
			service.login(testID,testPWD);
		}catch(InvalidPasswordException e){
			Assert.assertEquals(1,3);
		}catch(NotFoundIDException e){
			Assert.assertEquals(1,4);
		}
		
	
	}
	
	@Test
	public void testInsert() throws SQLException {
		MemberVO member=new MemberVO();
		member.setId("mimi");
		member.setPwd("mimi");
		member.setName("mimi");
		member.setPhone("000-0000-1234");
		try {
			service.regist(member);			
			Assert.assertEquals(1, 1);
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			Assert.assertEquals(1, 2);
		}
	}
	
	@Test
	public void testMemberDetail() throws SQLException {
		MemberVO member = new MemberVO();
		
		String id = "mimi";
		member =service.getMember(id);
		
		Assert.assertEquals(id, member.getPwd());
	}
		
}








