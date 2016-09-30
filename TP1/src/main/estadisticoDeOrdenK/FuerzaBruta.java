package estadisticoDeOrdenK;

public class FuerzaBruta implements BuscadorEstadisticoDeOrdenK {
	

	@Override
	public Integer buscarEstadisticoDeOrdenK(Integer[] conjunto, int k) {
		for (int i = 0; i < conjunto.length; i++){
			int candidato = conjunto[i];
			if (esElEstadisticoDeOrdenK(conjunto, k, candidato)){
				return candidato;
			}
		}
		return null;
	}
	
	private boolean esElEstadisticoDeOrdenK(Integer[] conjunto, int k, int candidato){
		int cantidadDeMenores = 0;
		for (int i = 0; i < conjunto.length; i++){
			if (conjunto[i] < candidato){
				cantidadDeMenores++;
			}
		}
		return cantidadDeMenores == k;
	}

}
