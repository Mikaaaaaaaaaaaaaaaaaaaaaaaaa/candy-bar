package ar.edu.unlam.dominio;

public abstract class Producto {

	protected String nombre;
	protected int stock;
	protected double precioBase;

	public Producto(String nombre, Integer stock, Double precioBase) {
		this.nombre = nombre;
		this.stock = stock;
		this.precioBase = precioBase;
	}

	public abstract double calcularPrecioFinal();

	public String getNombre() {
		return nombre;
	}
}