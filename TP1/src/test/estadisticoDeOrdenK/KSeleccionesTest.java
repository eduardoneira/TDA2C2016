package estadisticoDeOrdenK;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KSeleccionesTest extends BuscadorEstadisticoDeOrdenKTest {

	@Override
	protected BuscadorEstadisticoDeOrdenK buscador() {
		return new KSelecciones();
	}

	/*
	 * Mejor caso: conjunto ordenado t = 1.65*exp(-9) s
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
	 * Peor caso: conjunto ordenado al reves t = 1.26*exp(-4) s
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
