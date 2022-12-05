package kr.jieun.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude="board")
public class FileEntity {
	
	public FileEntity() {
		
	}
	
	@Id
    @GeneratedValue
    @Column(name="FILE_ID")
    private Long fileid;
    
    private String orgNm;
    
    private String savedNm;
    
    private String savedPath;
    
    @ManyToOne
	@JoinColumn(name="BOARD_ID", nullable=false, updatable=false)
	private Board board;
	
	public void setBoard(Board board) {
		this.board = board;
		board.getListFile().add(this);
	}

    @Builder
    public FileEntity(Long fileid, String orgNm, String savedNm, String savedPath) {
        this.fileid = fileid;
        this.orgNm = orgNm;
        this.savedNm = savedNm;
        this.savedPath = savedPath;
    }

}
