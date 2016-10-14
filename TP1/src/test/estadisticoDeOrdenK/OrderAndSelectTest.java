package estadisticoDeOrdenK;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrderAndSelectTest extends BuscadorEstadisticoDeOrdenKTest {

	@Override
	protected BuscadorEstadisticoDeOrdenK buscador() {
		return new OrderAndSelect();
	}

	/*
	 * Mejor caso: particiones balanceadas t =  s
	 */
	@Test
	public void mejorCasoOrderAndSelectTest() {
								
	}

	/*
	 * Peor caso: particiones desbalanceadas t =  s
	 */
	@Test
	public void peorCasoOrderAndSelectTest() {
																																																																																																																																																				
	}

}
