package grafos;

import estadisticoDeOrdenK.BuscadorEstadisticoDeOrdenK;
import estadisticoDeOrdenK.KHeapsort;

public class KHeapsortTest extends BuscadorEstadisticoDeOrdenKTest{

	@Override
	protected BuscadorEstadisticoDeOrdenK buscador() {
		return new KHeapsort();
	}

}
