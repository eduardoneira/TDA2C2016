package grafos.recorridos;

import java.util.List;

import grafos.Arista;
import grafos.Digrafo;

public abstract class Caminos {

	private static final double INFINITY = Double.POSITIVE_INFINITY;
	
    protected Integer src;
    protected Integer dest;

    protected double dist[];
    protected Arista edge[];
    
    public Caminos(Digrafo g, Integer origen, Integer destino) {
        src = origen;
        dest = destino;
        
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
    	//TODO Devolver el camino a v por edge[]
    	return null;
    }
    
    public boolean visitado(int v) {
        return distancia(v) < INFINITY;
    }

}