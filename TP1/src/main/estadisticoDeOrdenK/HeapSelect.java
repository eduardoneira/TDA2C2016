package estadisticoDeOrdenK;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapSelect implements BuscadorEstadisticoDeOrdenK {

	@Override
	public Integer buscarEstadisticoDeOrdenK(Integer[] conjunto, int k) {
		if (k < 0 || k >= conjunto.length){
			return null;
		}
		int heapMaxSize = k + 1;
		Queue<Integer> maxHeap = new PriorityQueue<Integer>(heapMaxSize, Collections.reverseOrder());
		for (int i = 0; i < conjunto.length; i++){
			Integer actual = conjunto[i];
			if(maxHeap.size() < heapMaxSize){
				maxHeap.add(actual);
			} else if (actual < maxHeap.peek()){
				maxHeap.poll();
				maxHeap.add(actual);
			}
		}
		return maxHeap.poll();
	}
	

}