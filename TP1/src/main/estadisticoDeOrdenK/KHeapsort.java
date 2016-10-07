package estadisticoDeOrdenK;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Edu
 * k-heapsort: 	este algoritmo mejora el de k-selecciones haciendo k extracciones 
 * 				a un arreglo con la propiedad de heap.
 */
public class KHeapsort implements BuscadorEstadisticoDeOrdenK {

	@Override
	public Integer buscarEstadisticoDeOrdenK(Integer[] conjunto, int k) {
		
		if (k < 0 || k >= conjunto.length){
			return null;
		}
		Queue<Integer> heap = null;
		
		//Dependiendo el k tengo que ver que heap me convendria, si es menor
		//a la mitad uso un minHeap, sino un maxHeap
		boolean kMenorALaMitad = k > conjunto.length/2;
		
		if (kMenorALaMitad) {
			heap = new PriorityQueue<Integer>(conjunto.length,Collections.reverseOrder());
		} else{
			heap = new PriorityQueue<Integer>(conjunto.length);
		}
		
		for ( int i = 0; i < conjunto.length; i++){
			heap.add(conjunto[i]);
		}
		
		int lastIndex = (kMenorALaMitad) ? conjunto.length - 1 - k : k;
		
		for (int i = 0; i < lastIndex; i++){
			heap.remove();
		}
		
		return heap.peek();
	}
	

}
