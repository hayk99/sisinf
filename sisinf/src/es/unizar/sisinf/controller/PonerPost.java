package es.unizar.sisinf.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.unizar.sisinf.data.dao.UsuarioDAO;
/** 
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) 
 */


public class PonerPost extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		// Llamada al metodo post
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		try {	
			System.out.println("Dale dale");
			boolean correcto;
			HttpSession session = request.getSession();
			String tit = request.getParameter("title");
			String body = request.getParameter("text");
			System.out.println(tit);
			System.out.println(body);
			String correo = (String)session.getAttribute("mail");
			
			correcto = new UsuarioDAO().insertPost(tit, body, correo);
						
			if (correcto) {
				System.out.println("Correcta la publicacion");
				request.setAttribute("msg", "Se ha publicado correctamente el post");
				request.getRequestDispatcher("jsp/publicado.jsp").forward(request, response);
			}
			else {
				System.out.println("Mal la publicacion");
				request.setAttribute("error", "Debe iniciar sesión para publicar un post");
				request.getRequestDispatcher("jsp/publicadoMal.jsp").forward(request, response);
			}
		}catch(Throwable theException) {
		}
	}
}
