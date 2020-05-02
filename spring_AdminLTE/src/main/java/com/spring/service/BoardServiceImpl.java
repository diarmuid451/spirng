package com.spring.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.dao.BoardDAO;
import com.spring.dao.ReplyDAO;
import com.spring.dto.BoardVO;
import com.spring.request.PageMaker;
import com.spring.request.SearchCriteria;

public class BoardServiceImpl implements BoardService {
	
	private BoardDAO boardDAO;
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	private ReplyDAO replyDAO;
	public void setReplyDAO(ReplyDAO replyDAO) {
		this.replyDAO = replyDAO;
	}
	
	@Override
	public List<BoardVO> getBoardList(SearchCriteria cri) throws SQLException {
		List<BoardVO> boardList = boardDAO.selectBoardCriteria(cri);
		
		for (BoardVO boardVO : boardList) {
			int cnt = replyDAO.countReply(boardVO.getBno());
			boardVO.setReplycnt(cnt);
		}
		
		return boardList;
	}

	@Override
	public BoardVO getBoard(int bno) throws SQLException {
		boardDAO.increaseViewCnt(bno);
		BoardVO board = boardDAO.selectBoardByBno(bno);
		int cnt = replyDAO.countReply(bno);
		board.setReplycnt(cnt);
		return board;
	}

	@Override
	public BoardVO getBoardForModify(int bno) throws SQLException {
		BoardVO board = boardDAO.selectBoardByBno(bno);
		return board;
	}

	@Override
	public void write(BoardVO board) throws SQLException {
		boardDAO.insertBoard(board);
	}

	@Override
	public void modify(BoardVO board) throws SQLException {
		boardDAO.updateBoard(board);
	}

	@Override
	public void remove(int bno) throws SQLException {
		boardDAO.deleteBoard(bno);
	}
	@Override
	public void viewCnt(int bno) throws SQLException {
		boardDAO.increaseViewCnt(bno);
		
	}
	@Override
	public int seqNextVal() throws SQLException {
		int seq = boardDAO.selectBoardSeqNext();
		return seq;
	}
	
	

}
