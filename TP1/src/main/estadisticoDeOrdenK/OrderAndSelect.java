package estadisticoDeOrdenK;

public class OrderAndSelect implements BuscadorEstadisticoDeOrdenK {

	@Override
	public Integer buscarEstadisticoDeOrdenK(Integer[] list, int k) {
		if (k < 0 || list.length == 0 || k >= list.length)
			return null;

		quicksort(list, 0, list.length - 1);
		return list[k];
	}
	
	
	public void quicksort(Integer list[], int izq, int der) {

		int pivote = list[izq]; // tomamos primer elemento como pivote
		int i = izq; 
		int j = der; 
		int aux;

		while (i < j) { 
			while (list[i] <= pivote && i < j)
				i++; 
			while (list[j] > pivote)
				j--; 
			if (i < j) { 
				aux = list[i]; 
				list[i] = list[j];
				list[j] = aux;
			}
		}
		list[izq] = list[j]; 
		list[j] = pivote; 
		if (izq < j - 1)
			quicksort(list, izq, j - 1); 
		if (j + 1 < der)
			quicksort(list, j + 1, der); 
	}
}
