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
	
	private void swap(Integer[] A, int i, int j) {
		Integer aux = A[i];
		A[i] = A[j];
		A[j] = aux;
	}
	
	private int partition(Integer[] A, int p, int r){
		Integer pivot = A[r];
		int i = p - 1;
		for (int j = p; j < r; j++){
			if (A[j] <= pivot){
				i++;
				swap(A,i,j);
			}
		}
		swap(A, i + 1, r);
		return i + 1;
	}
	
	private int randomizedPartition(Integer[] A, int p, int r) {
		int i = random.nextInt(r - p + 1) + p;
		swap(A, r, i);
		return partition(A, p, r);
	}
	
	private Integer quickSelect(Integer[] A, int p, int r, int i){
		if (p == r){
			return A[p];
		}
		int q = randomizedPartition(A, p, r);
		int k = q - p + 1;
		if (i == k){
			// the pivot value is the answer
			return A[q];
		} else if (i < k){
			return quickSelect(A, p, q - 1, i);
		} else {
			return quickSelect(A, q + 1, r, i - k);
		}
	}
	



	
/*
 * PARTITION (A,p,r)
 * 		x = A[r]
 * 		i = p - 1
 * 		for j = p to r - 1
 * 			if A[j] <= x
 * 				i++
 * 				swap(A,i,j)
 * 		swap(A, i+1, r)
 * 		return i+1
 * 
 * RANDOMIZED-PARTITION (A,p,r)
 * 		i = RANDOM(p,r)
 * 		swap(A, r, i)
 * 		return PARTITION (A,p,r)
 * 
 * RANDOMIZED-SELECT (A,p,r,i)
 * 		if p == r
 * 			return A[p]
 * 		q = RANDOMIZED-PARTITION (A, p, r)
 * 		k = q - p + 1
 * 		if i == k // the pivot value is the answer
 * 			return A[q]
 * 		elseif i < k
 * 			return RANDOMIZED-SELECT (A,p,q-1,i)
 * 		else 
 * 			return RANDOMIZED-SELECT (A,q+1,r,i-k)
 */
	
}
