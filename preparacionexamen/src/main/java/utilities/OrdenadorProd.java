package utilities;

import java.util.Comparator;

import modelo.dto.Producto;

public class OrdenadorProd implements Comparator<Producto> {

	protected String comparation;

	public OrdenadorProd(String comparation) {
		super();
		this.comparation = comparation;
	}

	public int compare(Producto a, Producto b) {
		if (this.comparation.equals("asc")) {
			return Integer.compare(Integer.parseInt(a.getCodigo()), Integer.parseInt(b.getCodigo()));
		} else {
			return Integer.compare(Integer.parseInt(b.getCodigo()),Integer.parseInt(a.getCodigo()));
		}
	}
}
