package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.dao.ReplyDAO;
import com.spring.dto.ReplyVO;
import com.spring.request.SearchCriteria;

public class MockReplyDAO implements ReplyDAO {

	@Override
	public void insertReply(ReplyVO reply) throws SQLException {
		

	}

	@Override
	public void updateReply(ReplyVO reply) throws SQLException {
		

	}

	@Override
	public void deleteReply(int rno) throws SQLException {
		

	}

	@Override
	public int selectReplySeqNextValue() throws SQLException {
		int cnt = 0;
		
		return cnt;
	}

	@Override
	public List<ReplyVO> selectReplyListPage(int bno, SearchCriteria cri) throws SQLException {
		List<ReplyVO> replyListPage = null;
		return replyListPage;
	}

	@Override
	public int countReply(int bno) throws SQLException {
		int cnt = 0;
		if(bno == 1) {
			cnt = 11;
		} else if(bno == 3) {
			cnt = 3;
		} else {
			cnt = 0;
		}
		
		return cnt;
	}

}
