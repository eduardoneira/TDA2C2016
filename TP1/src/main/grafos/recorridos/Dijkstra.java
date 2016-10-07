package grafos.recorridos;

import grafos.Arista;
import grafos.Digrafo;

public class Dijkstra extends Caminos {

	public Dijkstra(Digrafo g, Integer origen, Integer destino) {
		super(g, origen, destino);
	}
	
	private void relax(Integer u, Integer v, Digrafo g){
		Arista aristaUV = g.arista(u, v);
		if (dist[v] > dist[u] + aristaUV.getWeight()){
			dist[v] = dist[u] + aristaUV.getWeight();
			edge[v] = aristaUV;
		}
	}

	@Override
	protected void calcularDistancias() {
		// TODO Auto-generated method stub
		
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
