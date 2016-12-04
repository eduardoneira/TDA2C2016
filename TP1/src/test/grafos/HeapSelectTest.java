package grafos;

import estadisticoDeOrdenK.BuscadorEstadisticoDeOrdenK;
import estadisticoDeOrdenK.HeapSelect;

public class HeapSelectTest extends BuscadorEstadisticoDeOrdenKTest{

	@Override
	protected BuscadorEstadisticoDeOrdenK buscador() {
		return new HeapSelect();
	}
	
}
