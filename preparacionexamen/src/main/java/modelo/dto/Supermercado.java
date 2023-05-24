package modelo.dto;

import java.util.ArrayList;

public class Supermercado {

	protected int id;
	protected String nombre;
	protected ArrayList<Producto> productos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public Supermercado(int id, String nombre, ArrayList<Producto> productos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.productos = productos;
	}

	public Supermercado() {
		super();
	}

}
