package es.unizar.sisinf.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) 
 */


public class EnviarCorreoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private String mensajeSub = "Se ha subscrito satisfactoriamente a ecoZity.";
	private String asuntoSub = "Suscripción ecoZity";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		try {	
			String correo = request.getParameter("EMAIL");
			System.out.println(correo);
			System.out.println(asuntoSub);
			System.out.println(mensajeSub);
			new CorreosGmail().enviarConGMail(correo, asuntoSub, mensajeSub);
			request.setAttribute("msg", "Suscripción correcta, compruebe su correo");
			request.getRequestDispatcher("jsp/mandarMail.jsp").forward(request, response);
			System.out.println("ya");
		}catch(Throwable theException) {
			theException.printStackTrace();
		}
	}
}
