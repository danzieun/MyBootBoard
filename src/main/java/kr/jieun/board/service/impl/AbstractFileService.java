package kr.jieun.board.service.impl;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import kr.jieun.board.entity.Board;
import kr.jieun.board.entity.FileEntity;
import kr.jieun.board.service.FileService;

public class AbstractFileService implements FileService {

	@Override
	public Long saveFile(MultipartFile files, Board board) throws IOException {
		return null;
	}
	
	@Override
	public void deleteFile(FileEntity fileEntity) {
		
	}

}
