package es.unizar.sisinf.controller;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class CorreosGmail {
    // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
    private static final String remitente = "ecozity@gmail.com";  //Para la dirección nomcuenta@gmail.com
    private static final String clave ="javijesushayk";
    private static Properties props() {
	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
	    props.put("mail.smtp.user", remitente);
	    props.put("mail.smtp.clave", clave);
	    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
	    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
	    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google
	    props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	    return props;
    }
	public void enviarConGMail(String destinatario, String asunto, String cuerpo) {
			System.out.println("hola");
			Properties props = props();
			Session session = Session.getDefaultInstance(props);
			MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(remitente));
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   //Se podrían añadir varios de la misma manera
	        message.setSubject(asunto);
	        message.setText(cuerpo);
	        Transport transport = session.getTransport("smtp");
	        transport.connect(remitente, clave);
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close(); 
	   }
	    catch (MessagingException me) {
	        me.printStackTrace();   //Si se produce un error
	    }
	}
}
