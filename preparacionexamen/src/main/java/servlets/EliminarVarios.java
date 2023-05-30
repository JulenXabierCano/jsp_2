package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ModeloProducto;

/**
 * Servlet implementation class EliminarVarios
 */
@WebServlet("/EliminarVarios")
public class EliminarVarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EliminarVarios() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] codigos = request.getParameter("codigos").split(",");
		boolean eliminarCodigos=false;
		for (String codigo : codigos) {
			if (ModeloProducto.comprobar("codigo", codigo)) {
				eliminarCodigos=true;
			}else {
				eliminarCodigos=false;
			}
		}
		if(eliminarCodigos) {
			ModeloProducto.purgar(codigos);
		}
		response.sendRedirect("Inicio");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
