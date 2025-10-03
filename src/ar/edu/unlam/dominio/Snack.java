package ar.edu.unlam.dominio;

public class Snack extends Producto {

	private String tamanio;

	public Snack(String nombre, Integer stock, Double precioBase, String tamanio) {
		super(nombre, stock, precioBase);
		this.tamanio = tamanio;
	}

	@Override
	public double calcularPrecioFinal() {

		Double precioFinal = super.precioBase;
		if (Tamano.GRANDE.equals(this.tamanio)) {
			precioFinal *= 1.20;
		} else if (Tamano.PEQUENO.equals(this.tamanio)) {
			precioFinal *= 0.85;
		}

		return precioFinal;
	}
}