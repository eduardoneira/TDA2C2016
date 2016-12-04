package grafos;

import estadisticoDeOrdenK.BuscadorEstadisticoDeOrdenK;
import estadisticoDeOrdenK.FuerzaBruta;

public class FuerzaBrutaTest extends BuscadorEstadisticoDeOrdenKTest{

	@Override
	protected BuscadorEstadisticoDeOrdenK buscador() {
		return new FuerzaBruta();
	}
	
}
