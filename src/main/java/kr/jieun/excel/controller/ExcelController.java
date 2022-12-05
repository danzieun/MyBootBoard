package kr.jieun.excel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.jieun.board.entity.Board;
import kr.jieun.excel.service.ExcelService;

@Controller
public class ExcelController {
	
	@Autowired
	private ExcelService excelService;
	
	@RequestMapping(value="/download")
	public void listDownload(
			@ModelAttribute Board board,
			HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		excelService.listDownload(board, response);
	}

}
