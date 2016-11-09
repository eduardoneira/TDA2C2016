package travellingSalesman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class TravellingSalesman {
	
	private Integer[][] costs;
	
	private Integer V;
	
	private Integer v0;
	
	List<Integer> minPath;
	
	Integer minDistance;
	
	Map<Long,Integer> minDistanceDP;
	
	public TravellingSalesman(Integer[][] costs, Integer v0) {
		this.costs = costs;
		this.v0 = v0;
		this.V = costs.length;
		this.minPath = new ArrayList<>();
		this.minDistanceDP = new HashMap<>();
		
		long mask = (long) Math.pow(2, this.V+1) - 1;
		HashSet<Integer> S = new HashSet<>();
		
		for (Integer i = 1; i <= this.V; i++) {
			if(i.equals(v0)) {
				mask &= ~(1 << i);
			}
			S.add(i);
		}
		
		this.minDistance = this.bellamFord(v0, mask,S);		
	}
	
	@SuppressWarnings("unchecked")
	private Integer bellamFord(Integer v, long mask, HashSet<Integer> S){
		if (S.size() == 0) {
			return costs[v][v0];
		} else {
			Integer min = Integer.MAX_VALUE;

			for (Integer u : S) {
				HashSet<Integer> S_u = (HashSet<Integer>) S.clone();
				S_u.remove(u);
				long mask_u = mask & ~(1 << u);
				//Falta definir como entrar al map, tengo que hacer una clase id
				min = Math.min(min, costs[v][u] + bellamFord(u,mask_u,S_u));
			}
			return min;
		}
	}
	
	private String serializeSet(HashSet<Integer> S){ // O(V)
		StringBuilder sb = new StringBuilder("");
		for (Integer elem : S)  {
			sb.append(elem);
		}
		return sb.toString();
	}
	
	private String serializeKey(Integer v, HashSet<Integer> S) {
		return String.valueOf(v)+serializeSet(S);
	}
}
