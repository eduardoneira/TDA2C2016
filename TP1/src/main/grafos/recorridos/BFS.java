package grafos.recorridos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import grafos.Arista;
import grafos.Digrafo;

public class BFS extends Caminos {

    private double dist[];
    private Arista edge[];

    public BFS(Digrafo g, Integer origin) {
    	super(g, origin);
    }

    @Override
    public double distancia(Integer v) { 
    	return dist[v]; 
    }

	@Override
	protected void calcularDistancias() {
		//TODO: tal vez refactorizar esto, no me gusta que este aca
    	this.dist = new double[this.diGraph.n()];
        this.edge = new Arista[this.diGraph.n()];
		
		//Inicializar dist, -1 representa el infinito
		for (int i = 0; i < this.diGraph.n(); i++){
			if (i != this.src){
				this.dist[i] = Double.POSITIVE_INFINITY;
			}
		}
		
		dist[this.src] = 0;
		
		//Cola para ir guardando nodos
		Queue<Integer> queue = new LinkedList<>();
		
		//Guardo el origen
		queue.offer(this.src);
		
		while (!queue.isEmpty()){
			Integer current = queue.poll();
			
			for (Integer node : this.diGraph.adyacentes(current)){
				if (!this.visitado(node)) {
					this.dist[node] = this.dist[current] + 1;
					this.edge[node] = new Arista(current, node, -1); // Este BFS va a ignorar el peso, de nuevo me cago en el espacio :p
					queue.offer(node);
				}
			}
		}
		
		
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
	   
    private Arista aristaHaciaVertice(Integer v) { 
    	return edge[v]; 
    }
}