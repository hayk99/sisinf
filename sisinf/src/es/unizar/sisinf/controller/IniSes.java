package es.unizar.sisinf.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.unizar.sisinf.data.dao.UsuarioDAO;
import es.unizar.sisinf.data.vo.*;

/** 
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) 
 */


public class IniSes extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		// Llamada al metodo post
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		try {	
			boolean correcto;
			String correo = request.getParameter("correo");
			String pass = request.getParameter("password");
			System.out.println(correo);
			System.out.println(pass);
			correcto = new UsuarioDAO().checkPassword(correo, pass);
						
			if (correcto) {
				System.out.println("Correcta la comprobacion");
				HttpSession session = request.getSession(true);

				session.setAttribute("mail", request.getParameter("correo"));
				request.setAttribute("msg", "Inicio de sesion correcto");
				request.getRequestDispatcher("jsp/inicioBien.jsp").forward(request, response);
			}
			else {
				System.out.println("Mal la comprobacion");
				request.setAttribute("error", "Credenciales incorrectas");
				request.getRequestDispatcher("jsp/errorIni.jsp").forward(request, response);
			}
		}catch(Throwable theException) {
		}
	}
}
