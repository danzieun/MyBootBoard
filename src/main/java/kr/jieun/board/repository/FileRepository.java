package kr.jieun.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.jieun.board.entity.FileEntity;

public interface FileRepository extends JpaRepository<FileEntity, Long> {

}
