package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.dto.Seccion;

public class ModeloSeccion {
	public static void cargarSeccionesNoVa() {
		// cargar todas las secciones
	}

	public static Seccion cargarSeccion(int id) {
		Seccion s = new Seccion();
		String consulta = "select nombre from secciones where id =?";

		try {
			PreparedStatement st = Conector.conector.prepareStatement(consulta);
			st.setInt(1, id);
			ResultSet r = st.executeQuery();

			r.next();
			s.setId(id);
			s.setNombre(r.getString(1));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return s;
	}
}
