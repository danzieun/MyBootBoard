package kr.jieun.excel.service;

import javax.servlet.http.HttpServletResponse;

import kr.jieun.board.entity.Board;

public interface ExcelService {
	
	public void listDownload(Board board, HttpServletResponse response);

}
