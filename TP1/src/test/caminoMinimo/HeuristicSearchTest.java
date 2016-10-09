package caminoMinimo;

import static org.junit.Assert.*;

import org.junit.Test;

import grafos.Grilla;
import grafos.heuristicas.NullHeuristic;
import grafos.recorridos.Caminos;
import grafos.recorridos.HeuristicSearch;

//TODO : hacer un test posta y una mejor manera de generar caminos, estaba re duro cuando hice esto
public class HeuristicSearchTest {

	@Test
	public void compilaTest() {
		Grilla graph = this.generarTodosLosCaminos();
		
		Caminos camino = new HeuristicSearch(graph, 0, 7, new NullHeuristic());
		
		assertTrue(camino != null);
	}
	
	private Grilla generarTodosLosCaminos(){
		Grilla graph = new Grilla(9,true);
		
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
