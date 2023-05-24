package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modelo.dto.Supermercado;

public class ModeloSupermercado {
	public static ArrayList<Supermercado> cargarSupermercados() {
		ArrayList<Supermercado> supermercados = new ArrayList<Supermercado>();

		Conector.conectar();

		try {
			PreparedStatement st = Conector.conector.prepareStatement("select * from supermercados");
			ResultSet r = st.executeQuery();
			while (r.next()) {
				Supermercado s = new Supermercado();

				s.setId(r.getInt(1));
				s.setNombre(r.getString(2));

				supermercados.add(s);
			}
		} catch (Exception e) {
		}

		Conector.cerrar();

		return supermercados;
	}
}
