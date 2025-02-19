package es.unizar.sisinf.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.unizar.sisinf.data.dao.UsuarioDAO;
import es.unizar.sisinf.data.vo.*;

public class GetNews extends HttpServlet {
	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;
			
	/** 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		// Llamada al metodo post
		doPost(request, response);
	}
	/** 
	* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) 
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		try {
		List<PublicacionVO> lista = new UsuarioDAO().getAllNews();
		System.out.println(lista.get(1).getId());
		System.out.println(lista.get(1).getTitle());
		request.setAttribute("listaDemo", lista);
		request.getRequestDispatcher("jsp/foro.jsp").forward(request, response);
		}catch(Throwable theException) {
			
		}
	}
}
