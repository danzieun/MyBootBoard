package kr.jieun.mail.component;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import kr.jieun.mail.domain.MailDTO;

@Component
public class GoogleSMTPMailSender {
	
	@Autowired
	private JavaMailSender javaEmailSender;
	
	private static final String From_ADDRESS = "jieun3744@gmail.com";
	
	// 첨부파일이 있는 메일 발송
	public void sendMessageWithAttachment(MailDTO mailDTO) throws Exception {

		MimeMessage message = javaEmailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setFrom(From_ADDRESS);
		helper.setTo(mailDTO.getMailTo());
		helper.setSubject(mailDTO.getMailSubject());
		helper.setText(mailDTO.getMailContent());
		
		for (String attachFileName : mailDTO.getMailFilePath()) {
			File file = new File(attachFileName);
			helper.addAttachment(file.getName()
				, new FileSystemResource(file));			
		}

		javaEmailSender.send(message);
	}
	
} // class
