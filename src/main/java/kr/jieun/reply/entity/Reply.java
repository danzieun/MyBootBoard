package kr.jieun.reply.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import kr.jieun.board.entity.Board;
import kr.jieun.member.entity.Member;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude={"board", "member"})
public class Reply {
	
	@Id
	@GeneratedValue
	private Long rseq;
	
	private String replycontent;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable=false)
	private Date replyDate = new Date();
	
	@ManyToOne
	@JoinColumn(name="BOARD_ID", updatable=false)
	private Board board;
	
	public void setBoard(Board board) {
		this.board = board;
		board.getListReply().add(this);
	}
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID", nullable=false, updatable=false)
	private Member member;
	
	public void setMember(Member member) {
		this.member = member;
		member.getListReply().add(this);
	}
	
}
