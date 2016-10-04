package estadisticoDeOrdenK;

public class KHeapsortTest extends BuscadorEstadisticoDeOrdenKTest{

	@Override
	protected BuscadorEstadisticoDeOrdenK buscador() {
		return new KHeapsort();
	}

}
