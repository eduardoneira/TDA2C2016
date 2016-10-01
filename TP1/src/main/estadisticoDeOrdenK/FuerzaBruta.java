package estadisticoDeOrdenK;

public class FuerzaBruta implements BuscadorEstadisticoDeOrdenK {
	

	@Override
	public Integer buscarEstadisticoDeOrdenK(Integer[] conjunto, int k) {
		for (int i = 0; i < conjunto.length; i++){
			if (esElEstadisticoDeOrdenK(conjunto, k, i)){
				return conjunto[i];
			}
		}
		return null;
	}
	
	private boolean esElEstadisticoDeOrdenK(Integer[] conjunto, int k, int candidatoIdx){
		int cantidadDeMenores = 0;
		int cantidadDeIguales = 0;
		
		for (int i = 0; i < conjunto.length; i++){
			if (i != candidatoIdx){
				Integer candidato = conjunto[candidatoIdx];
				if (conjunto[i] < candidato){
					cantidadDeMenores++;
				} else if (conjunto[i].equals(candidato)){
					cantidadDeIguales++;
				}
			}
		}
		return ((cantidadDeMenores <= k) && (k <= cantidadDeMenores + cantidadDeIguales));
	}

}
