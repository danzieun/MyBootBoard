package kr.jieun.board.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import kr.jieun.board.entity.Board;
import kr.jieun.board.entity.FileEntity;

public interface FileService {
	
	public Long saveFile(MultipartFile files, Board board) throws IOException;
	
	public void deleteFile(FileEntity fileEntity);

}
