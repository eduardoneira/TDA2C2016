package grafos.recorridos;

import java.util.PriorityQueue;
import java.util.Queue;

import grafos.Arista;
import grafos.Grilla;
import grafos.VerticeGrilla;
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
		
		Grilla grilla = (Grilla) this.g;
		
		this.heuristica.setDestination(grilla.getPuntoDeVertice(this.dest));
		
		Queue<VerticeGrilla> queue = new PriorityQueue<>(grilla.n(),heuristica);
		
		queue.offer(grilla.getVerticeGrilla(this.src));
		
		while (!queue.isEmpty() && !this.visitado(this.dest)){
			VerticeGrilla current = queue.poll();
			
			for (Integer node : grilla.adyacentes(current.getV())){
				if (!this.visitado(node)) {
					this.dist[node] = this.dist[current.getV()] + 1;
					this.edge[node] = new Arista(current.getV(), node, -1);
					queue.offer(grilla.getVerticeGrilla(node));
				}
			}
		}
			
	}
}
