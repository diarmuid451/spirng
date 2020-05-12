package com.test.dataSource;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;


import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/com/spring/context/root-context.xml")
@TransactionConfiguration(transactionManager="transactionManager")
@Transactional
public class TestMemberDAOImpl {
	
	
	
	@Test
	public void testSelectMember() throws SQLException {
		String id = "sisi";
		
	
	}
	
	@Test
	public void testInsertMember() throws SQLException {
		
	}
}
