package grafos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import estadisticoDeOrdenK.BuscadorEstadisticoDeOrdenK;
import estadisticoDeOrdenK.KSelecciones;

public class KSeleccionesTest extends BuscadorEstadisticoDeOrdenKTest {

	@Override
	protected BuscadorEstadisticoDeOrdenK buscador() {
		return new KSelecciones();
	}

	/* El mejor y peor caso tienen la misma complejidad para selection sort */
	
	/*
	 * Mejor caso: conjunto ordenado
	 */
	@Test
	public void mejorCasoKSeleccionesTest() {
		int longitud = 16;
		Integer[] conjunto = new Integer[longitud];
		for (int i = 0; i < conjunto.length; i++)
			conjunto[i] = i;

		int k = longitud - 1;
		assertEquals(new Integer(15), buscador.buscarEstadisticoDeOrdenK(conjunto, k));
	}

	/*
	 * Peor caso: conjunto ordenado al reves
	 */
	@Test
	public void peorCasoKSeleccionesTest() {
		int longitud = 16;
		longitud--;
		Integer[] conjunto = new Integer[longitud];
		for (int i = 0; i < conjunto.length; i++)
			conjunto[i] = longitud - i;

		int k = longitud - 1;
		assertEquals(new Integer(15), buscador.buscarEstadisticoDeOrdenK(conjunto, k));
	}

}
