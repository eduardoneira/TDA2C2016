package grafos;

import estadisticoDeOrdenK.BuscadorEstadisticoDeOrdenK;
import estadisticoDeOrdenK.QuickSelect;

public class QuickSelectTest extends BuscadorEstadisticoDeOrdenKTest {

	@Override
	protected BuscadorEstadisticoDeOrdenK buscador() {
		return new QuickSelect();
	}

}
