package kr.jieun.mail.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.jieun.mail.component.GoogleSMTPMailSender;
import kr.jieun.mail.domain.MailDTO;

@Service
public class MailServiceImpl extends AbstractMailService {
	
	@Autowired
	private GoogleSMTPMailSender mailSender;

	@Override
	public void sendAttachMail(MailDTO mailDTO) {
		try {
			mailSender.sendMessageWithAttachment(mailDTO);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
