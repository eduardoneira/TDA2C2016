package grafos.recorridos;

import java.util.List;

import grafos.Arista;
import grafos.Digrafo;

public abstract class Caminos {

    protected Integer src;
    protected Digrafo diGraph;

    protected Caminos(Digrafo g, Integer origin) {
        src = origin;
        diGraph = g;
        init();
        calcularDistancias();
    }
    
    protected abstract void init();

    protected abstract void calcularDistancias();

    public abstract double distancia(Integer v);

    public abstract List<Arista> camino(Integer v);
    
    public boolean visitado(int v) {
        return distancia(v) < Double.POSITIVE_INFINITY;
    }

}