package kr.jieun.board.service.impl;

import org.springframework.data.domain.Page;

import kr.jieun.board.entity.Board;
import kr.jieun.board.entity.Search;
import kr.jieun.board.service.BoardService;

public class AbstractBoardService implements BoardService {

	@Override
	public void insertBoard(Board board) {

	}

	@Override
	public void updateBoard(Board board) {

	}

	@Override
	public void deleteBoard(Board board) {

	}

	@Override
	public Board getBoard(Board board) {
		return null;
	}

	@Override
	public Page<Board> listBoard(Search search, int page) {
		return null;
	}

}
