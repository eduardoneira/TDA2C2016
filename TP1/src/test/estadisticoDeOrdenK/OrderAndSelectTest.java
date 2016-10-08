package estadisticoDeOrdenK;

public class OrderAndSelectTest extends BuscadorEstadisticoDeOrdenKTest {

	@Override
	protected BuscadorEstadisticoDeOrdenK buscador() {
		return new OrderAndSelect();
	}

}
