package kr.jieun.reply.service;

import org.springframework.data.domain.Page;

import kr.jieun.board.entity.Board;
import kr.jieun.reply.entity.Reply;

public interface ReplyService {
	
	public void insertReply(Reply reply);
	
	public void updateReply(Reply reply);
	
	public void deleteReply(Reply reply);
	
	public Reply getReply(Reply reply);
	
	public Page<Reply> listReply(Board board, int page);

}
