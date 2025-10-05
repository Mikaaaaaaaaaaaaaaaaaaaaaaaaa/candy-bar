package ar.edu.unlam.dominio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CandyBarTest {

    private CandyBar candyBar;
    private Snack palomitas;
    private Bebida refresco;

//  Se ejecuta antes de cada test para inicializar el objeto CandyBar.
    @Before
	public void setUp() {
		this.candyBar = new CandyBar(5); // Capacidad para 5 productos
		this.palomitas = new Snack("Palomitas", 10, 5.0, Tamano.MEDIANO);
		this.refresco = new Bebida("Refresco", 15, 3.0, Contenedor.VASO);
	}

    @Test
	public void testAgregarProducto() {
		assertTrue(this.candyBar.agregarProducto(palomitas));
		assertEquals(1, contarProductosEnInventario());

		assertTrue(this.candyBar.agregarProducto(refresco));
		assertEquals(2, contarProductosEnInventario());
	}

    @Test
    public void testEliminarProductoExistente() {
        this.candyBar.agregarProducto(this.palomitas);
        this.candyBar.agregarProducto(this.refresco);

        assertTrue(this.candyBar.eliminarProducto("Palomitas"));
        assertEquals(1, contarProductosEnInventario());
//      assertNull(this.candyBar.obtenerProductos());
    }

    @Test
	public void testEliminarProductoNoExistente() {
		this.candyBar.agregarProducto(palomitas);

		assertFalse(this.candyBar.eliminarProducto("Chocolate"));
		assertEquals(1, contarProductosEnInventario());
	}

    @Test
	public void testInventarioLleno() {
//    	Llenar el inventario hasta su capacidad
		for (int i = 0; i < 5; i++) {
			this.candyBar.agregarProducto(new Snack("Snack " + i, 5, 1.0, Tamano.MEDIANO));
		}

//      Intentar agregar un sexto producto
		assertFalse(this.candyBar.agregarProducto(new Snack("Snack Extra", 3, 1.0, Tamano.MEDIANO)));
		assertEquals(5, contarProductosEnInventario());
	}

	private int contarProductosEnInventario() {
		Integer contador = 0;
		for (Object producto : this.candyBar.obtenerProductos()) {
			if (producto != null) {
				contador++;
			}
		}

		return contador;
	}

//	Modificaciones.
}