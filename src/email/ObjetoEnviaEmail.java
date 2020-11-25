package email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ObjetoEnviaEmail {
	
	private String userName = "fiapmbasenac@gmail.com";
	private String password = "123456Qa";
	private String listaDestinatario = "";
	private String nomeRemetente = "";
	private String assuntoEmail = "";
	private String corpoEmail = "";
	private String copia = "";
	
	public ObjetoEnviaEmail(String listaDestinatario, 
							String nomeRemetente, 
							String assuntoEmail, 
							String copia, 
							String corpoEmail) {
		this.listaDestinatario = listaDestinatario;
		this.nomeRemetente = nomeRemetente;
		this.assuntoEmail = assuntoEmail;
		this.copia = copia;
		this.corpoEmail = corpoEmail;
	
	}
	
	public void enviarEmail() throws Exception {
		
		Properties p = new Properties();
		p.put("mail.smtp.ssl.trust", "*");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls", "true");
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		Session session = Session.getInstance(p, new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(userName, password);
			}
		
		});
		
		Address[] toUser = InternetAddress.parse(listaDestinatario);
		Address[] toUserCC = InternetAddress.parse(copia);
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName, nomeRemetente));
		message.setRecipients(Message.RecipientType.TO, toUser);
		message.setRecipients(Message.RecipientType.CC, toUserCC);
		message.setSubject(assuntoEmail);
		message.setContent(corpoEmail, "text/html; charset=utf-8");
		
		Transport.send(message);
	}

}
