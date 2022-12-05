package kr.jieun.reply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.jieun.board.entity.Board;
import kr.jieun.board.service.BoardService;
import kr.jieun.member.entity.Member;
import kr.jieun.reply.entity.Reply;
import kr.jieun.reply.service.ReplyService;
import kr.jieun.security.domain.SecurityUser;

@Controller
@RequestMapping("/reply")
public class ReplyController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private ReplyService replyService;
	
	@PostMapping("/insertReplyProc")
	public String insertReplyProc(Reply reply, @AuthenticationPrincipal SecurityUser principal, Board board) {
		
		board = boardService.getBoard(board);
		reply.setBoard(board);
		
		reply.setMember(principal.getMember());
		
		replyService.insertReply(reply);
		
		return "redirect:/board/getBoard?seq=" + board.getSeq();
	}
	
	@GetMapping("/updateReply")
	public String updateReply(Reply reply, Board board, Member member, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		model.addAttribute("reply", replyService.getReply(reply));
		
		
		return "/reply/updateReply";
	}
	
	@PostMapping("/updateReplyProc")
	public String updateReplyProc(Reply reply, Board board, Model model) {
		
		replyService.updateReply(reply);
		
		model.addAttribute("reply", replyService.getReply(reply));
		return "redirect:/board/getBoard?seq=" + board.getSeq();
	}
	
	@GetMapping("/deleteReply")
	public String deleteReply(Reply reply, Board board) {
		replyService.deleteReply(reply);
		
		return "redirect:/board/getBoard?seq=" + board.getSeq();
	}

}
