package estadisticoDeOrdenK;

public class FuerzaBruta {

	public static boolean solve(Integer[] conjunto, int k, int candidato){
		int posicionMenor = 0;
		int posicionMayor = 0;
		
		for (int i = 0; i < conjunto.length; i++) {
			if (candidato > conjunto[i]){
				posicionMenor++;
			}
			if (candidato >= conjunto[i]){
				posicionMayor++;
			}
		}
		
		return (k >= posicionMenor && k < posicionMayor);
	}
}
