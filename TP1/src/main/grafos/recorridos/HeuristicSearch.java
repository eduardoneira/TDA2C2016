package grafos.recorridos;

import grafos.Digrafo;
import grafos.heuristicas.Heuristic;


public class HeuristicSearch extends BFS {

	private Heuristic heuristic;
	
	protected HeuristicSearch(Digrafo g, Integer origin) {
		super(g, origin);
	}
	
	
	@Override
	//TODO: implementar :p 
	protected void calcularDistancias() {
	
	}



	public void setHeuristic(Heuristic heuristic) {
		this.heuristic = heuristic;
		super.init();
		calcularDistancias();
	}
}
