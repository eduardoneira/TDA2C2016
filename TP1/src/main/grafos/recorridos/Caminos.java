package grafos.recorridos;

import java.util.ArrayList;
import java.util.List;

import grafos.Arista;
import grafos.Digrafo;

public abstract class Caminos {

	private static final double INFINITY = Double.POSITIVE_INFINITY;
	
    protected Integer src;
    protected Integer dest;
    protected Digrafo g;

    protected double dist[];
    protected Arista edge[];
    
    public Caminos(Digrafo g, Integer origen, Integer destino) {
        src = origen;
        dest = destino;
        this.g = g;
        
        dist = new double[g.n()];
        edge = new Arista[g.n()];
        
        for (int i = 0; i < dist.length; i++){
        	dist[i] = INFINITY;
        }
        dist[origen] = 0;
        
        calcularDistancias();
    }

    protected abstract void calcularDistancias();

    public double distancia(Integer v){
    	return dist[v];
    }

    public Arista aristaHaciaVertice(Integer v) { 
    	return edge[v]; 
    }
    
    public List<Arista> camino(Integer v){
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
    
    public boolean visitado(int v) {
        return distancia(v) < INFINITY;
    }

}