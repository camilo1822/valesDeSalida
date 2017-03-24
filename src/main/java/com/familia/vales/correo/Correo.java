package com.familia.vales.correo;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletResponse;


public class Correo {

	private String smtpHost;
	private int smtpPort;

	public Correo(String smtpHost, int smtpPort) {
		this.smtpHost = smtpHost;
		this.smtpPort = smtpPort;
	}

	
	public void enviarCorreoHtml(String de, String destinatario, String asunto, String cuerpo, HttpServletResponse response)
			throws AddressException, MessagingException {
		if (null == destinatario) {
			throw new IllegalArgumentException("No se ha especificado destinatario para env�o del correo");
		}
		if (null == de) {
			throw new IllegalArgumentException("No se ha especificado el usuario que env�a el formulario de cont�ctenos");
		}

		Properties properties = new Properties();
		properties.put("mail.smtp.host", smtpHost);
		properties.put("mail.smtp.localhost", smtpHost);
		properties.put("hostname", smtpHost);
		properties.put("mail.smtp.port", smtpPort);

		Session session = Session.getDefaultInstance(properties, null);
		session.setDebug(true);

		MimeMessage msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(de));
		Address toAddress = new InternetAddress(destinatario);
		msg.setRecipient(Message.RecipientType.TO, toAddress);

		msg.setSubject(asunto, "ISO-8859-1");
		msg.setSentDate(new Date());

		MimeBodyPart messageBodyPart = new MimeBodyPart();

		MimeMultipart multipart = new MimeMultipart("related");
		multipart.addBodyPart(messageBodyPart);

		messageBodyPart.setText(cuerpo, "ISO-8859-1");
		messageBodyPart.setHeader("Content-Type", "text/html; charset=\"ISO-8859-1\"");
		messageBodyPart.setHeader("Content-Transfer-Encoding", "quoted-printable");

		msg.setContent(multipart);

		Transport transport = null;
		try {
			response.setContentType("text/html");
			transport = session.getTransport("smtp");
			transport.connect();
			transport.sendMessage(msg, msg.getAllRecipients());
		} catch (Exception e) {

		} finally {
			if (transport != null) {
				transport.close();
			}
		}
	}
}