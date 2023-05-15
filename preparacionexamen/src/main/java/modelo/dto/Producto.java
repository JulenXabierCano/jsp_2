package modelo.dto;

import java.util.Date;

public class Producto {
	private int id;
	private String codigo;
	private String nombre;
	private int cantidad;
	private double precio;
	private java.util.Date caducidad;
	private int id_seccion;

	public Producto() {
		super();
	}

	public Producto(int id, int cantidad, int id_seccion, String codigo, String nombre, Date caducidad, double precio) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.id_seccion = id_seccion;
		this.codigo = codigo;
		this.nombre = nombre;
		this.caducidad = caducidad;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getId_seccion() {
		return id_seccion;
	}

	public void setId_seccion(int id_seccion) {
		this.id_seccion = id_seccion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public java.util.Date getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(java.util.Date caducidad) {
		this.caducidad = caducidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
