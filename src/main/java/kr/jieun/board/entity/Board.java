package kr.jieun.board.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import kr.jieun.member.entity.Member;
import kr.jieun.reply.entity.Reply;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude={"member", "listReply", "listFile"})
public class Board {
	
	public Board() {
		
	}
	
	public Board(String category, String title, String content, Member member) {
		this.category = category;
		this.title = title;
		this.content = content;
		this.member = member;
	}
	
	@Id
	@GeneratedValue
	@Column(name="BOARD_ID")
	private Long seq;
	
	private String category;
	
	private String title;
	
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable=false)
	private Date createDate = new Date();
	
	@Column(columnDefinition="number default 0")
	private Long cnt = 0L;
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID", nullable=false, updatable=false)
	private Member member;
	
	public void setMember(Member member) {
		this.member = member;
		member.getListBoard().add(this);
	}
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Reply> listReply = new ArrayList<Reply>();
	
	@OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<FileEntity> listFile = new ArrayList<FileEntity>();

}	// class
