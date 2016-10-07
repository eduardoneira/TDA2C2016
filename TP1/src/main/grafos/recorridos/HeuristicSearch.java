package grafos.recorridos;

import java.util.ArrayList;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import grafos.Arista;
import grafos.Digrafo;
import grafos.Grilla;
import grafos.VerticeGrilla;
import grafos.heuristicas.HeuristicAlgortithm;


public class HeuristicSearch extends Caminos{

	private HeuristicAlgortithm heuristic;	
	private double dist[];
	private Arista edge[];
	private Integer dst;
	private Grilla grilla;
	
	public HeuristicSearch(Digrafo g, Integer origin) {
		super(g,origin);
	}
	
	
	public HeuristicSearch(Grilla g, Integer origin, HeuristicAlgortithm heuristic) {
		super(g,origin);
		this.heuristic = heuristic;
		this.grilla = g;
	}
	
    @Override
    public double distancia(Integer v) { 
    	return dist[v]; 
    }

	@Override
	public void calcularDistancias() {
		
		this.initDist();
		
		this.heuristic.setDestination(this.grilla.getVerticeGrilla(this.dst).getPunto());
		
		Queue<VerticeGrilla> queue = new PriorityQueue<>(this.grilla.n(),heuristic);
		
		queue.offer(this.grilla.getVerticeGrilla(this.src));
		
		while (!queue.isEmpty() && !(queue.peek().getV().equals(this.dst))){
			VerticeGrilla current = queue.poll();
			
			for (Integer node : this.grilla.adyacentes(current.getV())){
				if (!this.visitado(node)) {
					this.dist[node] = this.dist[current.getV()] + 1;
					this.edge[node] = new Arista(current.getV(), node, -1); // Este BFS va a ignorar el peso, de nuevo me cago en el espacio :o
					queue.offer(this.grilla.getVerticeGrilla(node));
				}
			}
		}
			
	}
	
	protected void initDist(){
		
		for (int i = 0; i < this.grilla.n(); i++){
			if (i != this.src){
				this.dist[i] = Double.POSITIVE_INFINITY;
			}
		}
		
		dist[this.src] = 0;
	}

	@Override
	public List<Arista> camino(Integer v) {
		// Si no existe el camino devuelvo null
		if (dist[v] == Double.POSITIVE_INFINITY) {
			return null;
		}
		
		List<Arista> camino = new ArrayList<Arista>();
		
		Integer nodoActual = v;
				
		while (nodoActual != this.src){
			Arista aristaAcutal = this.aristaHaciaVertice(nodoActual);
			camino.add(0, aristaAcutal);
			nodoActual = aristaAcutal.getSrc();
		}
		
		return camino;
	}
	   
    protected Arista aristaHaciaVertice(Integer v) { 
    	return edge[v]; 
    }

	@Override
	protected void init() {
    	this.dist = new double[this.diGraph.n()];
        this.edge = new Arista[this.diGraph.n()];		
	}
	
	public void setDestino(Integer dst){
		this.dst = dst;
	}

	
}
