package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.spring.dao.BoardDAO;
import com.spring.dao.ReplyDAO;
import com.spring.dto.BoardVO;
import com.spring.request.SearchCriteria;

import junit.framework.Assert;

public class TestBoardServiceImpl {
	
	private BoardDAO boardDAO = new MockBoardDAO();
	private ReplyDAO replyDAO = new MockReplyDAO();
	
	private BoardServiceImpl service;
	
	@Before
	public void init() {
		service = new BoardServiceImpl();
		service.setBoardDAO(boardDAO);
		service.setReplyDAO(replyDAO);
	}
	
	@Test
	public void testGetList() throws SQLException{
		SearchCriteria cri = new SearchCriteria();
		cri.setSearchType("w");
		cri.setKeyword("첫번째");
		
		List<BoardVO> list = service.getBoardList(cri);
		
		Assert.assertEquals(2, list.size());
		
	}
	
	@Test
	public void testGetBoard() throws SQLException {
		int bno = 1;
		int cnt = 0;
		
		BoardVO board = service.getBoard(bno);
		cnt = board.getReplycnt();
		
		Assert.assertEquals(11, cnt);
		
	}
	
	@Test
	public void testInsert() throws SQLException {
		
	}

}
