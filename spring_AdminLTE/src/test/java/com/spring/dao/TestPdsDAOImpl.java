package com.spring.dao;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.PdsDAO;
import com.spring.dto.PdsVO;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/com/spring/context/root-context.xml")
@TransactionConfiguration(transactionManager="transactionManager")
@Transactional
public class TestPdsDAOImpl {
	
	
	@Autowired
	private PdsDAO pdsDAO;
	
	@Test
	public void testSelectPdsByPno() throws SQLException {
		int pno = 541;
		
		PdsVO pds = pdsDAO.selectPdsByPno(pno);
		
		Assert.assertEquals(pno, pds.getPno());
	}
	
	@Test
	public void testInsertPds() throws SQLException {
		PdsVO pds = new PdsVO();
		
		pds.setPno(pdsDAO.getSeqNextValue());
		pds.setWriter("sisi");
		pds.setTitle("이거슨");
		pds.setContent("테스트용 자료입니다.");
		
		pdsDAO.insertPds(pds);
		
		PdsVO result = pdsDAO.selectPdsByPno(pds.getPno());
		
		Assert.assertEquals(pds.getPno(), result.getPno());
	}
}
