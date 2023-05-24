package utilities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.dao.Conector;

public class ComproProd {
	protected final static boolean ESTA_OK = true;
	protected final static boolean NO_ESTA_OK = false;
	
	
	public static boolean stockMayorCero(String id) {
		boolean comprobacionStockMayor0 = false;
		try {
			Conector.conectar();
			PreparedStatement st = Conector.conector.prepareStatement("select cantidad from productos where id = ?");
			st.setString(1, id);
			ResultSet r = st.executeQuery();
			r.next();
			if (r.getInt(1) > 0) {
				return ESTA_OK;
			}
		} catch (Exception e) {
			return NO_ESTA_OK;
		}
		return ESTA_OK;
	}
	
	public static boolean estaEnSupermercado() {
		
		
		return true;
	}
}
