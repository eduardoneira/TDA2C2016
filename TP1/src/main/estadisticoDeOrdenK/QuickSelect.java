package estadisticoDeOrdenK;

import java.util.Random;

public class QuickSelect implements BuscadorEstadisticoDeOrdenK {

	private Random random;
	
	public QuickSelect() {
		random = new Random();
	}
	
	@Override
	public Integer buscarEstadisticoDeOrdenK(Integer[] conjunto, int k) {
		if (conjunto.length == 0 || k < 0 || k >= conjunto.length){
			return null;
		}
		return quickSelect(conjunto, 0, conjunto.length - 1, k);
	}
	
	private void swap(Integer[] array, int i, int j) {
		Integer aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
	
	private int partition(Integer[] array, int start, int end){
		Integer pivot = array[end];
		int i = start - 1;
		for (int j = start; j < end; j++){
			if (array[j] <= pivot){
				i++;
				swap(array,i,j);
			}
		}
		swap(array, i + 1, end);
		return i + 1;
	}
	
	private int randomizedPartition(Integer[] array, int start, int end) {
		int pivotIdx = random.nextInt(end - start + 1) + start;
		swap(array, end, pivotIdx);
		return partition(array, start, end);
	}
	
	private Integer quickSelect(Integer[] array, int start, int end, int k){
		if (start >= end){
			return array[start];
		}
		int pivotIdx = randomizedPartition(array, start, end);
		if (k == pivotIdx){
			// the pivot value is the answer
			return array[pivotIdx];
		} else if (k < pivotIdx){
			return quickSelect(array, start, pivotIdx - 1, k);
		} else {
			return quickSelect(array, pivotIdx + 1, end, k);
		}
	}
	
	
}
