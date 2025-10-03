package ar.edu.unlam.dominio;

public class Bebida extends Producto {

	private String contenedor;

	public Bebida(String nombre, Integer stock, Double precioBase, String contenedor) {
		super(nombre, stock, precioBase);
		this.contenedor = contenedor;
	}

	@Override
	public double calcularPrecioFinal() {
		Double precioFinal = super.precioBase;

		if (Contenedor.BOTELLA.equals(this.contenedor)) {
			precioFinal *= 1.10;
		}

		return precioFinal;
	}
}