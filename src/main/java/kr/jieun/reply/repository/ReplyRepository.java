package kr.jieun.reply.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import kr.jieun.reply.entity.Reply;

public interface ReplyRepository extends CrudRepository<Reply, Long>, QuerydslPredicateExecutor<Reply> {
	
	@Query(" select r from Reply r ")
	Page<Reply> listReply(Pageable pageable);
	
}
