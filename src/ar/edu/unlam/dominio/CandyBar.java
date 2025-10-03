package ar.edu.unlam.dominio;

import java.util.ArrayList;

public class CandyBar {

	private Integer numeroCapacidad;
	private ArrayList<Producto> productos;

	public CandyBar(Integer numeroCapacidad) {
		this.numeroCapacidad = numeroCapacidad;
		this.productos = new ArrayList<>();
	}

//	public boolean agregarProducto(Snack palomitas) {
//		return false;
//	}

//	public boolean agregarProducto(Bebida refresco) {
//		return false;
//	}

	public Boolean agregarProducto(Producto producto) { // Lo que hice fue generalizar el método para poder aprovechar polimorfismo
		if (this.productos.size() < this.numeroCapacidad) {
			this.productos.add(producto);
			return true;
		}

		return false;
	}

	public boolean eliminarProducto(String nombre) {
		for (Producto producto : this.productos) {
			if (producto != null && producto.getNombre().equals(nombre)) {
				this.productos.remove(producto);
				return true;
			}
		}

		return false;
	}

	public ArrayList<Producto> obtenerProductos() {
		return this.productos;
	}
}