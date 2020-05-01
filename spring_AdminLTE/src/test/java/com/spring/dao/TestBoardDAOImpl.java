package com.spring.dao;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.BoardDAO;
import com.spring.dto.BoardVO;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/com/spring/context/root-context.xml")
@TransactionConfiguration(transactionManager="transactionManager")
@Transactional
public class TestBoardDAOImpl {
	
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Test
	public void testSelectBoardByBno() throws SQLException {
		
		int bno = 345;
		
		BoardVO board = boardDAO.selectBoardByBno(bno);
		
		Assert.assertEquals(bno, board.getBno());
		
	}
	
	@Test
	public void testInsertBoard() throws SQLException {
		BoardVO board = new BoardVO();
		
		board.setBno(boardDAO.selectBoardSeqNext());
		board.setTitle("그녀의 웃음소리");
		board.setWriter("sisi");
		board.setContent("웨히히히히히히히히히히히");
		
		boardDAO.insertBoard(board);
		
		BoardVO result = boardDAO.selectBoardByBno(board.getBno());
		
		Assert.assertEquals(board.getWriter(), result.getWriter());
		
	}
}
