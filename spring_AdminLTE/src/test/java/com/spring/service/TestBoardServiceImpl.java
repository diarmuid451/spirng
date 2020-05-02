package com.spring.service;

import java.sql.SQLException;
import java.util.Date;
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
	
	private Date date = new Date();
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
		BoardVO board = new BoardVO();
		int bno = 1;
		board = new BoardVO();
		board.setBno(bno);
		board.setTitle("첫번째 제목");
		board.setContent("첫번쨰 내용");
		board.setWriter("첫번째 작성자");
		board.setViewcnt(0);
		board.setRegDate(date);
		board.setUpdatedate(date);
		
		try {
			service.write(board);			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		Assert.assertEquals(date, board.getRegDate());
	}

}
