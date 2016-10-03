package estadisticoDeOrdenK;

public class FuerzaBrutaTest extends BuscadorEstadisticoDeOrdenKTest{

	@Override
	protected BuscadorEstadisticoDeOrdenK buscador() {
		return new FuerzaBruta();
	}
	
}
