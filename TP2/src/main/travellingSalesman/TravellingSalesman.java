package travellingSalesman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TravellingSalesman {
	
	private Integer[][] costs;
	
	private Integer V;
	
	private Integer v0;
	
	List<Integer> minPath;
	
	Integer minDistance;
	
	//Voy a usar una lista de maps para guardar todo lindo, medio pesado pero la verdad que es jodido. Además de eso uso un mask para tener una key en los maps
	List<Map<Long,Integer>> minDistanceDP;
		
	public TravellingSalesman(Integer[][] costs, Integer v0) {
		this.costs = costs;
		this.v0 = v0 - 1; // resto uno asi tiene sentido con las estructuras
		this.V = costs.length;
		this.minPath = new ArrayList<>();
		this.minDistanceDP = new ArrayList<>(this.V);
		
		long mask =  (long) Math.pow(2, this.V) - 1;
		
		Set<Integer> S = new HashSet<>();
		
		for (Integer i = 0; i < this.V; i++) {
			if(i.equals(this.v0)) {
				mask &= ~(1 << i);
			} else {
				S.add(i);
			}
			this.minDistanceDP.add(new HashMap<>());
		}
		
		this.minDistance = this.heldKarp(this.v0,mask,S);
		this.buildPath(mask, S);
		
	}
	
	private Integer heldKarp(Integer v, long mask, Set<Integer> S) { // le agrego un parametro más para poder acceder al Map en O(1)
		if (S.size() == 0) {			
			return costs[v0][v];			
		} else {
			Integer min = Integer.MAX_VALUE;

			for (Integer u : S) {
				Set<Integer> S_u = new HashSet<Integer>(S);
				S_u.remove(u);
				
				long mask_u = mask & ~(1 << u);
				
				Integer distance_u;
				
				if ((distance_u = minDistanceDP.get(u).get(mask_u)) == null ) {
					distance_u = heldKarp(u,mask_u,S_u);
					minDistanceDP.get(u).put(mask_u, distance_u);
				}
				
				min = Math.min(min, costs[u][v] + distance_u);
			}
			
			return min;
		}
	}
	
	private void buildPath(long mask, Set<Integer> S) { // O(V*(V-1) /2) = O(V^2)
		
		minPath.add(v0 +1);
		
		Integer v = v0;
		
		while ( !S.isEmpty() ) {
			Integer min = Integer.MAX_VALUE;
			Integer next = v0; // Inicializo con cualquier bosta
			
			for (Integer u : S) {
				Set<Integer> S_u = new HashSet<Integer>(S);
				S_u.remove(u);
				
				long mask_u = mask & ~(1 << u);
				
				Integer uDistance = minDistanceDP.get(u).get(mask_u); // Siempre me tiene que traer distinto de null
				
				if ( min > costs[u][v] + uDistance){ // Si la distancia es la menor encontramos a cual era el siguiente
					next = u;
					min = costs[u][v] + uDistance;
				}
			}
			
			minPath.add(next+1);
			// Actualizo para el siguiente vertice
			v = next;
			S.remove(next);
			mask &= ~(1 << next);
		}
		
		minPath.add(v0+1);
	}
	
	public Integer recalculateMinDistance() { // O(V)
		Integer distance = 0;
		
		for (int i = 1; i < this.minPath.size() ; i++) {
			distance += this.costs[this.minPath.get(i)-1][this.minPath.get(i-1)-1];
		}
		
		return distance;
	}
}
