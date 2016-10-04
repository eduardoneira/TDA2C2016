package estadisticoDeOrdenK;

public class HeapSelectTest extends BuscadorEstadisticoDeOrdenKTest{

	@Override
	protected BuscadorEstadisticoDeOrdenK buscador() {
		return new HeapSelect();
	}
	
}
