package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conector {
	public static Connection conector;

	public static void conectar() {
		try {
			String url = "jdbc:mysql://localhost/wherehouse";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conector = (Connection) DriverManager.getConnection(url, "root", "");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: Al conectarse a la base de datos");
		}
	}

	public static void cerrar() {
		try {
			conector.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: No se ha podido cerrar la conexion");
		}
	}
}
