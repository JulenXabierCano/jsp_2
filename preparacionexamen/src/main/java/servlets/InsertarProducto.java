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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("secciones", ModeloSeccion.cargarSecciones());
		request.getRequestDispatcher("insertarForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Producto p = new Producto();
		p.setCodigo(request.getParameter("codigo"));
		p.setNombre(request.getParameter("nombre"));
		p.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
		p.setPrecio(Double.parseDouble(request.getParameter("precio")));
		java.util.Date caducidad = null;
		try {
			caducidad = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("caducidad"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		p.setCaducidad(caducidad);
		
		int id = Integer.parseInt(request.getParameter("seccion"));
		p.setSeccion(new Seccion(id,null));
		
		ModeloProducto.insertarProducto(p);
		try {
			response.sendRedirect("Inicio");
		} catch (Exception e) {
		}
	}

}