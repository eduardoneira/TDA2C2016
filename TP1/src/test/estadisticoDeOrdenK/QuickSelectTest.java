package estadisticoDeOrdenK;

public class QuickSelectTest extends BuscadorEstadisticoDeOrdenKTest {

	@Override
	protected BuscadorEstadisticoDeOrdenK buscador() {
		return new QuickSelect();
	}

}
