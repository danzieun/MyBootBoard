package kr.jieun.reply.service.impl;

import org.springframework.data.domain.Page;

import kr.jieun.board.entity.Board;
import kr.jieun.reply.entity.Reply;
import kr.jieun.reply.service.ReplyService;

public class AbstractReplyService implements ReplyService {

	@Override
	public void insertReply(Reply reply) {

	}

	@Override
	public void updateReply(Reply reply) {

	}

	@Override
	public void deleteReply(Reply reply) {

	}

	@Override
	public Reply getReply(Reply reply) {
		return null;
	}

	@Override
	public Page<Reply> listReply(Board board, int page) {
		return null;
	}

}
