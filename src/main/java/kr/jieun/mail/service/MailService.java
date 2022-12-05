package kr.jieun.mail.service;

import kr.jieun.mail.domain.MailDTO;

public interface MailService {

	public abstract void sendAttachMail(MailDTO mailDTO);

}