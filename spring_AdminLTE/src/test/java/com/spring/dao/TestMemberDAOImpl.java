package com.spring.dao;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.MemberDAO;
import com.spring.dto.MemberVO;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/com/spring/context/root-context.xml")
@TransactionConfiguration(transactionManager="transactionManager")
@Transactional
public class TestMemberDAOImpl {
	
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	public void testSelectMember() throws SQLException {
		String id = "sisi";
		
		MemberVO member = memberDAO.selectMemberById(id);
		
		Assert.assertEquals(id, member.getId());
	}
	
	@Test
	public void testInsertMember() throws SQLException {
		MemberVO member = new MemberVO();
		member.setId("kakao");
		member.setPwd("kakao");
		member.setName("카카오");
		member.setAuthority("ROLE_ADMIN");
		member.setEmail("kakao@kakao.com");
		member.setPhone("010-1234-5678");
		member.setPicture("kakao.jpg");
		
		memberDAO.insertMember(member);
		
		MemberVO result = memberDAO.selectMemberById("kakao");
		
		Assert.assertEquals(member.getId(), result.getId());
	}
}
