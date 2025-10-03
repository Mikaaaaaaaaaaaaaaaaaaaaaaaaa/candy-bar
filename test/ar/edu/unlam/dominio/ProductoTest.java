package ar.edu.unlam.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProductoTest {

	@Test
	public void testCalculoPrecioFinalSnack() {
//		Un snack chico
		Snack palomitasPequenas = new Snack("Palomitas Pequeñas", 10, 4.0, Tamano.PEQUENO);
		assertEquals(3.4, palomitasPequenas.calcularPrecioFinal(), 0.01);

		Snack palomitasMedianas = new Snack("Palomitas Pequeñas", 10, 4.0, Tamano.MEDIANO);
		assertEquals(4.0, palomitasMedianas.calcularPrecioFinal(), 0.01);

//		Un snack con recargo del +20% por tamaño "Grande"
		Snack palomitasGrandes = new Snack("Palomitas Grandes", 5, 4.0, Tamano.GRANDE);
		assertEquals(4.8, palomitasGrandes.calcularPrecioFinal(), 0.01);
	}

	@Test
	public void testCalculoPrecioFinalBebida() {
//		Una bebida sin recargo
		Bebida refresco = new Bebida("Refresco Cola", 15, 3.0, Contenedor.VASO);
		assertEquals(3.0, refresco.calcularPrecioFinal(), 0.01);

//		Una bebida con recargo +10% por botella
		Bebida jugo = new Bebida("Jugo de Naranja", 8, 2.5, Contenedor.BOTELLA);
		assertEquals(2.75, jugo.calcularPrecioFinal(), 0.01);
	}

	@Test
	public void testCalculoPrecioFinalCombo() {
		Snack snack = new Snack("Nachos", 20, 6.0, Tamano.MEDIANO);
		Bebida bebida = new Bebida("Agua", 25, 2.0, Contenedor.VASO);

//		Un combo con 20% de descuento
		Combo comboConDescuento = new Combo("Combo Deluxe", snack, bebida, 0.20, 5);
		double precioEsperado = (6.0 + 2.0) * (1 - 0.20);
		assertEquals(precioEsperado, comboConDescuento.calcularPrecioFinal(), 0.01);

//		Un combo sin descuento
		Combo comboSinDescuento = new Combo("Combo Básico", snack, bebida, 0.0, 3);
		double precioEsperadoSinDescuento = 6.0 + 2.0;
		assertEquals(precioEsperadoSinDescuento, comboSinDescuento.calcularPrecioFinal(), 0.01);
	}
}