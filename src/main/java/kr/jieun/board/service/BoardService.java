package kr.jieun.board.service;

import org.springframework.data.domain.Page;

import kr.jieun.board.entity.Board;
import kr.jieun.board.entity.Search;

public interface BoardService {
	
	public void insertBoard(Board board);
	
	public void updateBoard(Board board);
	
	public void deleteBoard(Board board);
	
	public Board getBoard(Board board);
	
	public Page<Board> listBoard(Search search, int page);
	
}
