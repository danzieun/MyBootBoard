package kr.jieun.mail.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class MailDTO implements Serializable {
	
	public static final long serialVersionUID = 9823477983284L;
	
	public MailDTO() {
	}
	
	public MailDTO(String mailFrom, String mailTo, String mailSubject, String mailContent, String[] mailFilePath) {
		this.mailFrom = mailFrom;
		this.mailTo = mailTo;
		this.mailSubject = mailSubject;
		this.mailContent = mailContent;
		this.mailFilePath = mailFilePath;
	}
	
	private String mailFrom;		// 발신자 이메일
	private String mailTo;			// 수신자 이메일
	private String mailSubject;		// 메일 제목
	private String mailContent;		// 메일 내용
	private String[] mailFilePath;	// 첨부파일

} // class
