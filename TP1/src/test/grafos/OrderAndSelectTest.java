package grafos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import estadisticoDeOrdenK.BuscadorEstadisticoDeOrdenK;
import estadisticoDeOrdenK.OrderAndSelect;

public class OrderAndSelectTest extends BuscadorEstadisticoDeOrdenKTest {

	@Override
	protected BuscadorEstadisticoDeOrdenK buscador() {
		return new OrderAndSelect();
	}

	/*
	 * Mejor caso: particiones balanceadas, en este caso van a quedar la mitad
	 * de elementos a un lado del pivot y la otra mitad al otro lado (+-1) t = s
	 */
	@Test
	public void mejorCasoOrderAndSelectTest() {
		int longitud = 16;
		Integer[] conjunto = new Integer[longitud];
		for (int i = 0; i < conjunto.length / 2; i++)
			conjunto[i] = 1;
		for (int i = conjunto.length / 2; i < conjunto.length; i++)
			conjunto[i] = 2;
		int k = longitud - 1;
		assertEquals(new Integer(2), buscador.buscarEstadisticoDeOrdenK(conjunto, k));
	}

	/*
	 * Peor caso: particiones desbalanceadas, con todo el conjunto con iguales valores, esta ordenado y 
	 * se tiene el peor caso t = 217945ns
	 */
	@Test
	public void peorCasoOrderAndSelectTest() {
		int longitud = 16;
		Integer[] conjunto = new Integer[longitud];
		for (int i = 0; i < conjunto.length; i++)
			conjunto[i] = 1; 
		int k = longitud - 1;
		assertEquals(new Integer(1), buscador.buscarEstadisticoDeOrdenK(conjunto, k));
	}

}
