package com.spring.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.dao.ReplyDAO;
import com.spring.dto.ReplyVO;
import com.spring.request.PageMaker;
import com.spring.request.SearchCriteria;

public class ReplyServiceImpl implements ReplyService{
	
	
	private ReplyDAO replyDAO;
	public void setReplyDAO(ReplyDAO replyDAO){
		this.replyDAO=replyDAO;
	}
	
	@Override
	public List<ReplyVO> getReplyList(int bno, SearchCriteria cri) throws SQLException {
		List<ReplyVO> replyList=
				replyDAO.selectReplyListPage(bno, cri);
		return replyList;
	}

	@Override
	public void registReply(ReplyVO reply) throws SQLException {
		reply.setRno(replyDAO.selectReplySeqNextValue());
		replyDAO.insertReply(reply);

	}

	@Override
	public void modifyReply(ReplyVO reply) throws SQLException {
		replyDAO.updateReply(reply);

	}

	@Override
	public void removeReply(int rno) throws SQLException {
		replyDAO.deleteReply(rno);
	}
	@Override
	public int countReply(int bno) throws SQLException {
		int count = 0;
		count = replyDAO.countReply(bno);
		return count;
	}
	
}




