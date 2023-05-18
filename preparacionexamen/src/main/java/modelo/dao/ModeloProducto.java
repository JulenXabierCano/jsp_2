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

	public static void insertarProducto(Producto p) {
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
}
