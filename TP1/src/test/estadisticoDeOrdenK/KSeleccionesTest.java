package estadisticoDeOrdenK;

public class KSeleccionesTest extends BuscadorEstadisticoDeOrdenKTest {

	@Override
	protected BuscadorEstadisticoDeOrdenK buscador() {
		return new OrderAndSelect();
	}

}
