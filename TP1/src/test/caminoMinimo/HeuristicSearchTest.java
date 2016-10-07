package caminoMinimo;

import static org.junit.Assert.*;

import org.junit.Test;

import grafos.Grilla;
import grafos.Punto;
import grafos.heuristicas.EuclideanDistance;
import grafos.heuristicas.ManhattanDistance;
import grafos.heuristicas.NullHeuristic;
import grafos.recorridos.HeuristicSearch;

public class HeuristicSearchTest {

	@Test
	public void test() {
		Grilla graph = this.generarTodosLosCaminos();
		
		HeuristicSearch camino = new HeuristicSearch(graph, 0, new NullHeuristic());
		camino.setDestino(6);
		camino.calcularDistancias();
		
		System.out.println("termino el test");
	}
	
	private Grilla generarTodosLosCaminos(){
		Grilla graph = new Grilla(9);
		
		for (int i = 0; i < 2; i++){
			
			graph.agregarArista(i, i+1, 1);
			graph.agregarArista(i+1, i, 1);
			
			graph.agregarArista(3+i, 3+i+1, 1);
			graph.agregarArista(3+i+1, 3+i, 1);
			
			graph.agregarArista(6+i, 6+i+1, 1);
			graph.agregarArista(6+i+1, 6+i, 1);
			
		}
		
		for (int i = 0; i < 4; i+=3){
			
			graph.agregarArista(i, i+3, 1);
			graph.agregarArista(i+3, i, 1);
			
			graph.agregarArista(i+1, 3+i+1, 1);
			graph.agregarArista(3+i+1, i+1, 1);
			
			graph.agregarArista(2+i, 3+i+2, 1);
			graph.agregarArista(3+i+2, 2+i, 1);
			
		}
		
		
		return graph;
	}

}
