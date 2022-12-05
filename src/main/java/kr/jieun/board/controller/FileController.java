package kr.jieun.board.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriUtils;

import kr.jieun.board.entity.Board;
import kr.jieun.board.entity.FileEntity;
import kr.jieun.board.repository.FileRepository;
import kr.jieun.board.service.FileService;

@Controller
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private FileRepository fileRepo;
	
	// 이미지 출력
    @GetMapping("/images/{fileid}")
    @ResponseBody
    public Resource downloadImage(@PathVariable("fileid") Long fileid, Model model) throws IOException{

        FileEntity file = fileRepo.findById(fileid).orElse(null);
        model.addAttribute("filepath", file.getSavedPath());
        
        return new UrlResource("file:" + file.getSavedPath());
    }
    
    // 첨부 파일 다운로드
    @GetMapping("/attach/{fileid}")
    public ResponseEntity<Resource> downloadAttach(@PathVariable("fileid") Long fileid) throws MalformedURLException {

        FileEntity file = fileRepo.findById(fileid).orElse(null);

        UrlResource resource = new UrlResource("file:" + file.getSavedPath());

        String encodedFileName = UriUtils.encode(file.getOrgNm(), StandardCharsets.UTF_8);

        // 파일 다운로드 대화상자가 뜨도록 하는 헤더를 설정해주는 것
        // Content-Disposition 헤더에 attachment; filename="업로드 파일명" 값을 준다.
        String contentDisposition = "attachment; filename=\"" + encodedFileName + "\"";

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,contentDisposition).body(resource);
    }
    
    // 파일 삭제
    @GetMapping("/deleteFile")
	public String deleteFile(FileEntity fileEntity, Board board) {
		fileService.deleteFile(fileEntity);
		
		return "redirect:/board/getBoard?seq=" + board.getSeq();
	}

}
