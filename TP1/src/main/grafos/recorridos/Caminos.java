package grafos.recorridos;

import java.util.List;

import grafos.Arista;
import grafos.Digrafo;

public abstract class Caminos {

    private Integer src;

    protected Caminos(Digrafo g, Integer origin) {
        src = origin;
        calcularDistancias();
    }

    protected abstract void calcularDistancias();

    public abstract double distancia(Integer v);

    public abstract List<Arista> camino(Integer v);
    
    public boolean visitado(int v) {
        return distancia(v) < Double.POSITIVE_INFINITY;
    }

}