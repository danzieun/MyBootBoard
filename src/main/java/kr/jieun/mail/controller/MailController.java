package kr.jieun.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.jieun.board.entity.Board;
import kr.jieun.board.service.BoardService;
import kr.jieun.mail.domain.MailDTO;
import kr.jieun.mail.service.MailService;

@Controller
public class MailController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private MailService mailService;
	
	@GetMapping("/mail")
    public String sendMail() {
        return "mail";
    }
	
	@PostMapping("/mail")
	public String sendMailProc(MailDTO mailDTO, Board board, Model model) {

		model.addAttribute("board", boardService.getBoard(board));
		
		mailService.sendAttachMail(mailDTO);
		
		return "redirect:/board/getBoard?seq=" + board.getSeq();
	}

}
