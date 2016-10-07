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
	
	private void relax(Integer u, Integer v){
		Arista aristaUV = g.arista(u, v);
		if (dist[v] > dist[u] + aristaUV.getWeight()){
			dist[v] = dist[u] + aristaUV.getWeight();
			edge[v] = aristaUV;
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
		while (!minHeap.isEmpty()){
			Integer u = minHeap.poll();
			s.add(u);
			for (Integer v : g.adyacentes(u)){
				relax(u,v);
			}
		}
	}

/*	RELAX(u,v,w)
 * 		if v.d > u.d + w(u,v)
 * 			v.d = u.d + w(u,v)
 * 			v.p = u
 * 
 * INITIALIZE-SINGLE-SOURCE(G, s)
 * 		for each vertex v in G.V
 * 			v.d = infinity
 * 			v.p = NULL
 * 		s.d = 0
 * 
 * 	DIJKSTRA(G, w, s)
 * 		INITIALIZE-SINGLE-SOURCE(G, s)
 * 		S = {}
 * 		Q = G.V
 * 		while Q != {}
 * 			u = EXTRACT-MIN(Q)
 * 			S.add(u)
 * 			for each vertex v in G.adj(u)
 * 				RELAX(u,v,w)
 * 
 */
	
	
	
}
