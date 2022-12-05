package kr.jieun.board.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.jieun.board.entity.Board;
import kr.jieun.board.entity.FileEntity;
import kr.jieun.board.entity.Search;
import kr.jieun.board.repository.FileRepository;
import kr.jieun.board.service.BoardService;
import kr.jieun.board.service.FileService;
import kr.jieun.reply.entity.Reply;
import kr.jieun.reply.service.ReplyService;
import kr.jieun.security.domain.SecurityUser;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private FileRepository fileRepo;
	
	@RequestMapping("/listBoard")
	public String listBoard(Model model, Search search, @RequestParam(value="page", defaultValue="0") int page) {
		if (search.getSearchCondition() == null) {
			search.setSearchCondition("TITLE");
		}
		
		if (search.getSearchKeyword() == null) {
			search.setSearchKeyword("");
		}
		
		Page<Board> listBoard = boardService.listBoard(search, page);
		
		model.addAttribute("listBoard", listBoard);
		
		return "/board/listBoard";
	}
	
	@GetMapping("/getBoard")
	public String getBoard(
			Board board,
			Model model,
			@RequestParam(value="page", defaultValue="0") int page) {
		
		List<FileEntity> files = fileRepo.findAll();
		model.addAttribute("files", files);
		
		model.addAttribute("board", boardService.getBoard(board));
		
		Page<Reply> listReply = replyService.listReply(board, page);
		model.addAttribute("listReply", listReply);
		
		return "/board/getBoard";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoard() {
		return "/board/insertBoard";
	}
	
	@PostMapping("/insertBoardProc")
	public String insertBoardProc(
			Board board,
			@AuthenticationPrincipal SecurityUser principal,
			@RequestParam("files") List<MultipartFile> files) throws IOException {
		
		board.setMember(principal.getMember());
		boardService.insertBoard(board);
		
		for (MultipartFile multipartFile : files) {
            fileService.saveFile(multipartFile, board);
        }
		
		return "redirect:/board/listBoard";
	}
	
	@PostMapping("/updateBoardProc")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		
		return "redirect:/board/getBoard?seq=" + board.getSeq();
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		
		return "forward:/board/listBoard";
	}

}
