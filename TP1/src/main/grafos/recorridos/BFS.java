package grafos.recorridos;

import java.util.List;

import grafos.Arista;
import grafos.Digrafo;

public class BFS extends Caminos {

    private double dist[];  // Inicializar a +∞.
    private Arista edge[];

    public BFS(Digrafo g, Integer origin, Integer destino) {
        super(g, origin);
    }

    @Override
    public double distancia(Integer v) { 
    	return dist[v]; 
    }

	@Override
	protected void calcularDistancias() {
		// TODO Auto-generated method stub
		
        // ACA VA EL CODIGO DEL ALGORITMO. Rellena "dist" y "edge".
	}

	@Override
	public List<Arista> camino(Integer v) {
		// TODO Auto-generated method stub
		return null;
	}
	   
    private Arista aristaHaciaVertice(Integer v) { 
    	return edge[v]; 
    }
}