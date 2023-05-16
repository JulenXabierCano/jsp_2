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
			e.printStackTrace();
		}

		Conector.cerrar();
		return productos;
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
}
