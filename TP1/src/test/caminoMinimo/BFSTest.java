package caminoMinimo;

import static org.junit.Assert.*;

import org.junit.Test;

import grafos.Arista;
import grafos.Digrafo;
import grafos.recorridos.BFS;
import grafos.recorridos.Caminos;

//TODO: Refactorizar como estadistico, sacar una clase abstract
public class BFSTest {

	@Test
	public void test() {
		Digrafo graph = new Digrafo(6);
		graph.agregarArista(0, 1, 1);
		graph.agregarArista(0, 2, 1);
		graph.agregarArista(1, 3, 1);
		graph.agregarArista(3, 4, 1);
		graph.agregarArista(2, 5, 1);
		graph.agregarArista(3, 5, 1);
		
		Caminos camino = new BFS(graph, 0);
		assertTrue(camino.distancia(0) == 0);
		assertTrue(camino.distancia(1) == 1);
		assertTrue(camino.distancia(2) == 1);
		assertTrue(camino.distancia(3) == 2);
		assertTrue(camino.distancia(4) == 3);
		assertTrue(camino.distancia(5) == 2);
		
		for (int i = 0; i < graph.n() ; i++) {
			assertTrue(camino.camino(i).size() == camino.distancia(i));
		}
		
		Integer[] aristasCaminoMasLarga = new Integer[]{0,1,3,4};
		Integer indice = 0;
		for(Arista arista : camino.camino(aristasCaminoMasLarga[aristasCaminoMasLarga.length - 1])){
			assertTrue(arista.getSrc() == aristasCaminoMasLarga[indice]);
			assertTrue(arista.getDst() == aristasCaminoMasLarga[++indice]);
		}
	}

}
