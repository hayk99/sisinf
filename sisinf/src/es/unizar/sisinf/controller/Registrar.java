package es.unizar.sisinf.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.unizar.sisinf.data.dao.UsuarioDAO;
import es.unizar.sisinf.data.vo.*;

/** 
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) 
 */


public class Registrar extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		// Llamada al metodo post
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		String msg = "";
		try {	
			boolean existeUser;
			UsuarioVO newUser = null;
			String correo = request.getParameter("correo");
			String correoCheck = request.getParameter("correoCheck");
			String name = request.getParameter("username");
			String pass = request.getParameter("password");
			String passCheck  = request.getParameter("passCheck");
			if ((correo.equals(correoCheck)) && (pass.equals(passCheck))) {
				existeUser = new UsuarioDAO().existeUsuario(name);
				if (!existeUser) {
					newUser = new UsuarioVO(name, pass, correo);
					new UsuarioDAO().insertUser(newUser);
					msg = "Creado usuario de manera correcta";
					request.setAttribute("result", msg);
					System.out.println("llamo jsp crear");
					request.getRequestDispatcher("jsp/registroOK.jsp").forward(request, response);
				}
				else {
					msg = "El correo o el usuario ya está registrado \n Pruebe con uno diferentes \n :(((";
					request.setAttribute("errorExiste", "El correo o el usuario ya está registrado \n Pruebe con uno diferentes \n :(((");
					System.out.println("llamo jsp  existe");
					request.getRequestDispatcher("jsp/errorInsert_Coincidencia2.jsp").forward(request, response);
					System.out.println("llamado");
				}
			}
			else {
				msg = "El correo o la contraseña no coinciden :(((";
				request.setAttribute("errorResultado", "El correo o la contraseña no coinciden :(((");
				System.out.println("llamo jsp coincide");
				request.getRequestDispatcher("jsp/errorInsert_Coincidencia.jsp").forward(request, response);
			}
		}catch(Throwable theException) {
		}
	}
}
