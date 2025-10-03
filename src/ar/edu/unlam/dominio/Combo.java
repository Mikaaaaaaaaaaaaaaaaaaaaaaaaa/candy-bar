package ar.edu.unlam.dominio;

public class Combo extends Producto {

	private Snack snack;
	private Bebida bebida;
	private Double descuento; // Porcentaje de descuento, ejemplo 0.10 = 10%

	public Combo(String nombre, Snack snack, Bebida bebida, Double descuento, Integer stock) {
		super(nombre, stock, 1.0);
		this.snack = snack;
		this.bebida = bebida;
		this.descuento = descuento;
	}

	@Override
	public double calcularPrecioFinal() {
		Double precioFinal = this.snack.calcularPrecioFinal() + this.bebida.calcularPrecioFinal();
		return precioFinal *= (1 - this.descuento);
	}
}