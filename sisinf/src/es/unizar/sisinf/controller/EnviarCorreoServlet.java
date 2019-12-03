package es.unizar.sisinf.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) 
 */


public class EnviarCorreoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	String mensaje = "Se ha subscrito satisfactoriamente a ecoZity.";
	String asunto = "Suscripción ecoZity";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		// Llamada al metodo post
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		try {	
			String correo = request.getParameter("EMAIL");
			System.out.println(correo);
			this.enviar(correo, asunto, mensaje);
			
			
		}catch(Throwable theException) {
		}
		
	}
	
	protected void enviar(String destinatario, String asunto, String cuerpo) {
		String remitente = "ecozity";  //Para la dirección nomcuenta@gmail.com
	    String clave ="javijesushayk";
	    try {
		    Properties props = System.getProperties();
		    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
		    props.put("mail.smtp.user", remitente);
		    props.put("mail.smtp.clave", clave);    //La clave de la cuenta
		    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
		    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
		    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google
		    System.out.println("1");
		    Session session = Session.getDefaultInstance(props);
		    MimeMessage message = new MimeMessage(session);
		    System.out.println("2");
	        message.setFrom(new InternetAddress(remitente));
	        message.addRecipients(Message.RecipientType.TO, destinatario);   //Se podrían añadir varios de la misma manera
	        System.out.println("3");
	        message.setSubject(asunto);
	        message.setText(cuerpo);
	        System.out.println("4");
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitente, clave);
	        System.out.println("5");
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	        System.out.println("mail sent");
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();   //Si se produce un error
	    }
	}
}
