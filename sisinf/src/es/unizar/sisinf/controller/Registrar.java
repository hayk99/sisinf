package es.unizar.sisinf.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.unizar.sisinf.data.dao.UsuarioDAO;
import es.unizar.sisinf.data.vo.*;

public class Registrar extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		try {	
			UsuarioVO newUser = null;
			String correo = request.getParameter("correo");
			String correoCheck = request.getParameter("correoCheck");
			String name = request.getParameter("username");
			String pass = request.getParameter("pass");
			String passCheck  = request.getParameter("passCheck");
			if ((correo.equals(correoCheck)) && (pass.equals(passCheck))) {
				newUser = new UsuarioVO(name, pass, correo);
				boolean exito = new UsuarioDAO().insertUser(newUser);
				if (exito) {
					request.setAttribute("result", "Creado usuario correctamente");
					request.getRequestDispatcher("jsp/registroOK.jsp").forward(request, response);
				}	
			}
		}catch(Throwable theException) {
			
		}
	}
}
