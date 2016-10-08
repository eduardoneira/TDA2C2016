package estadisticoDeOrdenK;

public class KSelecciones implements BuscadorEstadisticoDeOrdenK {

	@Override
	public Integer buscarEstadisticoDeOrdenK(Integer[] list, int k) {
		if (k < 0 || list.length == 0 || k >= list.length)
			return null;

		return kSelectionSort(list, k)[k];
	}

	/*	
	 * Selection sort hasta el k-esimo 
	 */  
	public Integer[] kSelectionSort(Integer[] list, int k) {
		Integer[] kOrderedList = list;
		for (int i = 0; i <= k; i++) {
			int min = i;
			for (int j = i + 1; j < kOrderedList.length; j++) {
				if (kOrderedList[j] < kOrderedList[min])
					min = j;
			}
			if (i != min)
				swap(kOrderedList, i, min);
		}
		return kOrderedList;
	}

	public void swap(Integer[] array, int a, int b) {
		int aux = array[a];
		array[a] = array[b];
		array[b] = aux;
	}
}
