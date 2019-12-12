package es.unizar.sisinf.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) 
 */


public class EnviarContactoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final String correo ="ecozity@gmail.com";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		try {	
			String email_var = request.getParameter("email");
			String message_var = request.getParameter("message");
			String subject_var = request.getParameter("subject");
			System.out.println(correo);
			System.out.println(subject_var);
			System.out.println(message_var);
			new CorreosGmail().enviarConGMail(correo, subject_var +" FROM: "+email_var, message_var);
			request.setAttribute("msg", "Su mensaje nos ha llegado, en menos de 24 horas recibirá su respuesta");
			request.getRequestDispatcher("jsp/mandarContacto.jsp").forward(request, response);
			System.out.println("ya");
		}catch(Throwable theException) {
			theException.printStackTrace();
		}
	}
}
