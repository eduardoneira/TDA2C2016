package grafos.recorridos;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import grafos.Arista;
import grafos.Grilla;
import grafos.heuristicas.HeuristicAlgortithm;


public class HeuristicSearch extends Caminos{

	public HeuristicSearch(Grilla g, Integer origin, Integer destino, HeuristicAlgortithm heuristica) {
		super(g,origin,destino,heuristica);
	}
	
    @Override
    public double distancia(Integer v) { 
    	return dist[v]; 
    }

	@Override
	public void calcularDistancias() {		
		//TODO:  Arreglar esto en algún momento, la verdad bastante feo
		Grilla grilla = (Grilla) this.g;
		
		this.heuristica.setDestination(grilla.getPuntoDeVertice(this.dest));
		
		Queue<Integer> queue = this.createQueue(grilla);
		
		queue.offer(this.src);
		
		while (!queue.isEmpty()){
			Integer current = queue.poll();
			
			for (Integer node : grilla.adyacentes(current)){
				if (!this.visitado(node)) {
					this.dist[node] = this.dist[current] + 1;
					this.edge[node] = new Arista(current, node, -1);
					if (node == this.dest){
						return;
					}
					queue.offer(node);
				}

			}
		}
			
	}
	
	private Queue<Integer> createQueue(Grilla grilla){
		return new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer u, Integer v) {
				if (heuristica.distanceToDestination(grilla.getPuntoDeVertice(u)) < heuristica.distanceToDestination(grilla.getPuntoDeVertice(v)) ){
					return -1;
				} else if (heuristica.distanceToDestination(grilla.getPuntoDeVertice(u)) > heuristica.distanceToDestination(grilla.getPuntoDeVertice(v))){
					return +1;
				} else {
					return 0;
				}
			}
		});
	}
}
