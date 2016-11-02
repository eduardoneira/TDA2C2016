package grafos.recorridos;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import grafos.Arista;
import grafos.Digrafo;

public class Dijkstra extends Caminos {

	
	public Dijkstra(Digrafo g, Integer origen, Integer destino) {
		super(g, origen, destino);
	}
	
	private void relax(Queue<Integer> minHeap, Integer u, Integer v){
		Arista aristaUV = g.arista(u, v);
		if (dist[v] > dist[u] + aristaUV.getWeight()){
			dist[v] = dist[u] + aristaUV.getWeight();
			edge[v] = aristaUV;
			minHeap.add(v);
		}
	}

	@Override
	protected void calcularDistancias() {
		Set<Integer> s = new HashSet<Integer>();
		Queue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer u, Integer v) {
				if (dist[u] < dist[v]){
					return -1;
				} else if (dist[u] > dist[v]){
					return +1;
				} else {
					return 0;
				}
			}
		});
		
		minHeap.addAll(g.v());
		while (s.size() < g.n()){
			Integer u = minHeap.poll();
			if(!s.contains(u)){
				s.add(u);
				for (Integer v : g.adyacentes(u)){
					if (!s.contains(v)){
						relax(minHeap, u,v);
					}
				}
			}
		}
	}
	
}
