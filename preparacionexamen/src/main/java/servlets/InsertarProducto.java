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
import modelo.dao.ModeloSeccion;
import modelo.dto.Producto;
import modelo.dto.Seccion;

/**
 * Servlet implementation class InsertarProducto
 */
@WebServlet("/InsertarProducto")
public class InsertarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertarProducto() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("secciones", ModeloSeccion.cargarSecciones());
		String error = (String) request.getParameter("error");
		request.setAttribute("error", error);
		request.getRequestDispatcher("insertarForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean codigo_ok = ModeloProducto.comprobar(request.getParameter("codigo"), "codigo");

		java.util.Date caducidad = null;
		try {
			caducidad = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("caducidad"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			if (codigo_ok && Double.parseDouble(request.getParameter("precio")) < 0 && new java.util.Date().after(caducidad)
					&& (String) request.getParameter("seccion") != null) {
				Producto p = new Producto();
				p.setCodigo(request.getParameter("codigo"));
				p.setNombre(request.getParameter("nombre"));
				p.setPrecio(Double.parseDouble(request.getParameter("precio")));
				p.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
				p.setCaducidad(caducidad);

				int id = Integer.parseInt(request.getParameter("seccion"));
				p.setSeccion(new Seccion(id, null));

				ModeloProducto.insertarProducto(p);
				response.sendRedirect("Inicio");
			} else {
				
				response.sendRedirect("InsertarProducto?error=Error%20hay%20datos%20que%20ya%20existen%20en%20la%20bbdd");
			}
		}catch(Exception e) {
			
		}

	}

}
