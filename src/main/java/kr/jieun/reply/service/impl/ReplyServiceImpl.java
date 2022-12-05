package kr.jieun.reply.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;

import kr.jieun.board.entity.Board;
import kr.jieun.reply.entity.QReply;
import kr.jieun.reply.entity.Reply;
import kr.jieun.reply.repository.ReplyRepository;
import kr.jieun.reply.service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyRepository replyRepo;
	
	@Override
	public void insertReply(Reply reply) {
		replyRepo.save(reply);
	}

	@Override
	public void updateReply(Reply reply) {
		Reply findReply = replyRepo.findById(reply.getRseq()).get();
		
		findReply.setReplycontent(reply.getReplycontent());
		
		replyRepo.save(findReply);
	}

	@Override
	public void deleteReply(Reply reply) {
		replyRepo.deleteById(reply.getRseq());
	}

	@Override
	public Reply getReply(Reply reply) {
		return replyRepo.findById(reply.getRseq()).get();
	}

	@Override
	public Page<Reply> listReply(Board board, int page) {
		BooleanBuilder builder = new BooleanBuilder();
		
		QReply qreply = QReply.reply;

		builder.and(qreply.reply.board.seq.like("" + board.getSeq()));
		
		Pageable pageable = PageRequest.of(page, 10, Sort.Direction.DESC, "rseq");
		
		return replyRepo.findAll(builder, pageable);
	}

}
