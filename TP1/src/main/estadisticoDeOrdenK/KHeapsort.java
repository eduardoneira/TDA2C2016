package estadisticoDeOrdenK;

import java.util.PriorityQueue;

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
		
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		
		for ( int i = 0; i < conjunto.length; i++){
			heap.add(conjunto[i]);
		}
		
		for (int i = 0; i < k; i++){
			heap.remove();
		}
		
		return heap.peek();
	}
	

}
