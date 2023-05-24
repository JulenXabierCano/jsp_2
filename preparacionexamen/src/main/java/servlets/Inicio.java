package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ModeloProducto;
import modelo.dto.Producto;
import utilities.OrdenadorProd;

/**
 * Servlet implementation class Inicio
 */
@WebServlet("/Inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Inicio() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ArrayList<Producto> productosFiltrados = new ArrayList<Producto>();
			switch (request.getParameter("filtro")) {
			case "Buscar":
				// Filtrado por contencion de texto
				String comprobar = request.getParameter("busqueda").toLowerCase();
				for (Producto producto : ModeloProducto.cargarProductos()) {
					if (producto.getNombre().contains(comprobar) || producto.getCodigo().contains(comprobar)) {
						productosFiltrados.add(producto);
					}
				}
				request.setAttribute("productos", productosFiltrados);
				break;
			case "Filtrar":
				// Filtrado por precio
				Double min = Double.parseDouble(request.getParameter("precio_minimo"));
				Double max = Double.parseDouble(request.getParameter("precio_maximo"));

				for (Producto producto : ModeloProducto.cargarProductos()) {
					if (producto.getPrecio() > min && producto.getPrecio() < max) {
						productosFiltrados.add(producto);
					}
				}
				request.setAttribute("productos", productosFiltrados);
				break;
			case "codasc":
				ArrayList<Producto> productosAsc = ModeloProducto.cargarProductos();
				Collections.sort(productosAsc, new OrdenadorProd("asc"));
				request.setAttribute("productos", productosAsc);
				break;
			case "coddesc":
				ArrayList<Producto> productosDesc = ModeloProducto.cargarProductos();
				Collections.sort(productosDesc, new OrdenadorProd("desc"));
				request.setAttribute("productos", productosDesc);
				break;
			}
		} catch (NullPointerException e) {
			request.setAttribute("productos", ModeloProducto.cargarProductos());
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
