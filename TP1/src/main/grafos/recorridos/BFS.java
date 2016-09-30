package grafos.recorridos;

import grafos.Arista;
import grafos.Digrafo;

public class BFS extends Caminos {

    private double dist[];  // Inicializar a +∞.
    private Arista edge[];

    public BFS(Digrafo g, int origin, int destino) {
        super(g, origin);

        // código del algoritmo, rellena "dist" y "edge".
    }

    @Override
    public double distancia(int v) { 
    	return dist[v]; 
    }
    
    @Override    
    protected Arista aristaHaciaVertice(int v) { 
    	return edge[v]; 
    }
}