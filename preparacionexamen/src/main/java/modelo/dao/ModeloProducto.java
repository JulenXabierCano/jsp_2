package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modelo.dto.Producto;

public class ModeloProducto {
	public static ArrayList<Producto> cargarProductos() {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		String sentencia = "select * from productos";

		Conector.conectar();

		try {
			PreparedStatement st = Conector.conector.prepareStatement(sentencia);
			ResultSet r = st.executeQuery();

			while (r.next()) {
				Producto p = new Producto();

				p.setId(r.getInt(1));
				p.setCodigo(r.getString(2));
				p.setNombre(r.getString(3));
				p.setCantidad(r.getInt(4));
				p.setPrecio(r.getDouble(5));
				p.setCaducidad(r.getDate(6));
				p.setSeccion(ModeloSeccion.cargarSeccion(r.getInt(7)));

				productos.add(p);
			}

		} catch (Exception e) {
		}

		Conector.cerrar();
		return productos;
	}

	public static Producto cargarProducto(String id) {
		Producto p = new Producto();
		String sentencia = "select * from productos where id=?";

		Conector.conectar();

		try {
			PreparedStatement st = Conector.conector.prepareStatement(sentencia);
			st.setInt(1, Integer.parseInt(id));
			ResultSet r = st.executeQuery();

			if (r.next() == false) {
				System.out.println("No se ha encontrado el objeto");
			} else {
				p.setId(r.getInt(1));
				p.setCodigo(r.getString(2));
				p.setNombre(r.getString(3));
				p.setCantidad(r.getInt(4));
				p.setPrecio(r.getDouble(5));
				p.setCaducidad(r.getDate(6));
				p.setSeccion(ModeloSeccion.cargarSeccion(r.getInt(7)));
			}

		} catch (Exception e) {
		}

		Conector.cerrar();
		return p;
	}

	public static void insertarProducto(Producto p, String[] supermercados) {
		String sentencia = "insert into productos (codigo,nombre,cantidad,precio,caducidad,id_seccion) values (?,?,?,?,?,?)";
		Conector.conectar();

		try {
			PreparedStatement st = Conector.conector.prepareStatement(sentencia);

			st.setString(1, p.getCodigo());
			st.setString(2, p.getNombre());
			st.setInt(3, p.getCantidad());
			st.setDouble(4, p.getPrecio());
			try {
				st.setDate(5, new java.sql.Date(p.getCaducidad().getTime()));
			} catch (Exception e) {
				st.setDate(5, null);
			}
			st.setInt(6, p.getSeccion().getId());

			st.execute();

			sentencia = "insert into productos_supermercados (id_producto,id_supermercado) values (?,?)";
			st = Conector.conector.prepareStatement(sentencia);
			int lastId = cargarUltimoID();
			for (String s : supermercados) {
				st.setInt(1, lastId);
				st.setString(2, s);
				st.execute();
			}
		} catch (Exception e) {
		}

		Conector.cerrar();
	}

	public static boolean comprobar(String dato, String queEs) {
		final boolean no_se_inserta = false;
		final boolean se_inserta = true;
		boolean comprobacion = se_inserta;
		String sentencia = "select * from productos where ?=?";

		Conector.conectar();
		try {
			PreparedStatement st = Conector.conector.prepareStatement(sentencia);

			st.setString(1, queEs);
			st.setString(2, dato);

			ResultSet r = st.executeQuery();

			if (r.next()) {
				comprobacion = no_se_inserta;
			}

		} catch (Exception e) {
		}
		Conector.cerrar();

		return comprobacion;
	}

	public static void modificarProducto(Producto p) {
		String sentencia = "update productos set nombre=?,cantidad=?,precio=?,caducidad=?,id_seccion=? where codigo=?";

		Conector.conectar();

		try {
			PreparedStatement st = Conector.conector.prepareStatement(sentencia);

			st.setString(1, p.getNombre());
			st.setInt(2, p.getCantidad());
			st.setDouble(3, p.getPrecio());
			st.setDate(4, new java.sql.Date(p.getCaducidad().getTime()));
			st.setInt(5, p.getSeccion().getId());
			st.setString(6, p.getCodigo());

			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Conector.cerrar();
	}

	public static void eliminarProducto(String id) {
		String sentencia = "update productos set cantidad=cantidad-1 where id=?";

		Conector.conectar();

		if (conseguirStock(id) > 0) {
			try {
				PreparedStatement st = Conector.conector.prepareStatement(sentencia);
				st.setString(1, id);
				st.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (estaEnSupermercado(id)) {
			try {
				PreparedStatement st = Conector.conector
						.prepareStatement("delete from productos_supermercados where id_producto=?");
				st.setString(1, id);
				st.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else { // no hay stock y no está en ninguna tienda
			try {
				PreparedStatement st = Conector.conector.prepareStatement("delete from productos where id=?");
				st.setString(1, id);
				st.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Conector.cerrar();
	}

	public static int cargarUltimoID() {
		int id = 0;

		Conector.conectar();

		try {
			PreparedStatement st = Conector.conector.prepareStatement("select max(id) from productos");
			ResultSet r = st.executeQuery();
			r.next();
			id = r.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Conector.cerrar();

		return id;
	}

	protected static int conseguirStock(String id) {
		int stock = 0;

		try {
			PreparedStatement st = Conector.conector.prepareStatement("select cantidad from productos where id = ?");
			st.setString(1, id);
			ResultSet r = st.executeQuery();
			r.next();
			stock = r.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return stock;
	}

	private static boolean estaEnSupermercado(String id) {
		boolean existe = false;
		String sentencia = "select * from productos_supermercados where id = ?";

		try {
			PreparedStatement st = Conector.conector.prepareStatement(sentencia);
			st.setString(1, id);
			ResultSet r = st.executeQuery();
			if (r.next()) {
				existe = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return existe;
	}
}
