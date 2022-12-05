package kr.jieun.member.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import kr.jieun.board.entity.Board;
import kr.jieun.reply.entity.Reply;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude={"listBoard", "listReply"})
public class Member {
	
	public Member() {
		
	}
	
	public Member(String id, String password, String name, Role role, String enabled) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.role = role;
		this.enabled = enabled;
	}
	
	@Id
	@Column(name="MEMBER_ID")
	private String id;
	
	private String password;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	private String enabled;
	
	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Board> listBoard = new ArrayList<Board>();
	
	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Reply> listReply = new ArrayList<Reply>();

}
