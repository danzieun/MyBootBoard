package kr.jieun.board.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import kr.jieun.board.entity.Board;

public interface BoardRepository extends CrudRepository<Board, Long>, QuerydslPredicateExecutor<Board> {
	
	@Query(" select b from Board b ")
	Page<Board> listBoard(Pageable pageable);
	
	@Query(" select b from Board b ")
	List<Board> listBoard(Board board);

}
