package grafos.recorridos;

import java.util.List;

import grafos.Arista;
import grafos.Digrafo;

public abstract class Caminos {

    private int src;

    protected Caminos(Digrafo g, int origin) {
        src = origin;
    }

    public abstract double distancia(int v);

    protected abstract Arista aristaHaciaVertice(int v);

    public boolean visitado(int v) {
        return distancia(v) < Double.POSITIVE_INFINITY;
    }

    public List<Arista> camino(int v) {
    	//TODO
    	return null;
    }
}