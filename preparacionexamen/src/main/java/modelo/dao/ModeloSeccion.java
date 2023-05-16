package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modelo.dto.Seccion;

public class ModeloSeccion {
	public static ArrayList<Seccion> cargarSecciones() {
		ArrayList<Seccion> secciones = new ArrayList<Seccion>();
		String consulta = "select * from secciones";

		Conector.conectar();

		try {
			PreparedStatement st = Conector.conector.prepareStatement(consulta);
			ResultSet r = st.executeQuery();

			while (r.next()) {
				Seccion s = new Seccion();
				s.setId(r.getInt(1));
				s.setNombre(r.getString(2));
				secciones.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Conector.cerrar();
		
		return secciones;
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
