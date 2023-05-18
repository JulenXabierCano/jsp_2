package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ModeloProducto;
import modelo.dto.Producto;
import modelo.dto.Seccion;

/**
 * Servlet implementation class Modificar
 */
@WebServlet("/Modificar")
public class Modificar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Modificar() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("p", ModeloProducto.cargarProducto(request.getParameter("id")));
		request.getRequestDispatcher("modificarProducto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		java.util.Date caducidad = null;
		try {
			caducidad = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("caducidad"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Producto p = new Producto();
		p.setCodigo(request.getParameter("codigo"));
		p.setNombre(request.getParameter("nombre"));
		p.setPrecio(Double.parseDouble(request.getParameter("precio")));
		p.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
		p.setCaducidad(caducidad);

		int id = Integer.parseInt(request.getParameter("seccion"));
		p.setSeccion(new Seccion(id, null));

		ModeloProducto.modificarProducto(p);
		response.sendRedirect("Inicio");
	}

}
