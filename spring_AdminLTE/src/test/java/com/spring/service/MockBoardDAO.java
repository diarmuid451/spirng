package com.spring.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.spring.dao.BoardDAO;
import com.spring.dto.BoardVO;
import com.spring.request.SearchCriteria;

public class MockBoardDAO implements BoardDAO {
	
	private Date date = new Date();
	
	@Override
	public List<BoardVO> selectBoardCriteria(SearchCriteria cri) throws SQLException {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		if(cri.getSearchType().equals("w") && cri.getKeyword().equals("첫번째")) {
			BoardVO board1 = new BoardVO(1, "첫번째 제목", "첫번째 작성자", "첫번쨰 내용", 0, date, date);
			BoardVO board3 = new BoardVO(3, "세번째 제목", "첫번째 작성자", "세번쨰 내용", 0, date, date);
			
			boardList.add(board1);
			boardList.add(board3);		
		}
		return boardList;
	}

	@Override
	public int selectBoardCriteriaTotalCount(SearchCriteria cri) throws SQLException {
		int cnt = 0;
		if(cri.getSearchType().equals("w") && cri.getKeyword().equals("첫번째")) {
			cnt = 2;
		}
		return cnt;
	}

	@Override
	public BoardVO selectBoardByBno(int bno) throws SQLException {
		BoardVO board = null;
		
		if(bno != 1) return board;
		board = new BoardVO();
		board.setBno(bno);
		board.setTitle("첫번째 제목");
		board.setContent("첫번쨰 내용");
		board.setWriter("첫번째 작성자");
		board.setViewcnt(0);
		board.setRegDate(date);
		board.setUpdatedate(date);
		
		
		
		return board;
	}

	@Override
	public void insertBoard(BoardVO board) throws SQLException {
		if(board==null) throw new SQLException();
		if(board.getWriter()==null || board.getWriter().isEmpty()) 
				throw new SQLException("1111:부적합한 열유형"); 
		
		
	}

	@Override
	public void updateBoard(BoardVO board) throws SQLException {
		

	}

	@Override
	public void deleteBoard(int bno) throws SQLException {
		

	}

	@Override
	public void increaseViewCnt(int bno) throws SQLException {
		

	}

	@Override
	public int selectBoardSeqNext() throws SQLException {
		
		return 0;
	}

}
