package modelo.dto;

import java.util.Date;

public class Producto {
	private int id;
	private String codigo;
	private String nombre;
	private int cantidad;
	private double precio;
	private java.util.Date caducidad;
	private Seccion seccion;

	public Producto() {
		super();
	}

	public Producto(int id, int cantidad, Seccion seccion, String codigo, String nombre, Date caducidad, double precio) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.seccion = seccion;
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

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
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
