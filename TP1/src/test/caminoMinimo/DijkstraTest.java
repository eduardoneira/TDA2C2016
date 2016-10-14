package caminoMinimo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import grafos.Digrafo;
import grafos.recorridos.Caminos;
import grafos.recorridos.Dijkstra;

public class DijkstraTest {

	@Test
	public void grafoConUnaAristaTest() {
		Digrafo grafo = new Digrafo(2);
		grafo.agregarArista(0, 1, 5);
		
		Caminos camino = new Dijkstra(grafo, 0, 1);
		assertTrue(camino.distancia(0) == 0);
		assertTrue(camino.distancia(1) == 5);
	}

	@Test
	public void grafoConDosAristasTest() {
		Digrafo graph = new Digrafo(3);
		graph.agregarArista(0, 1, 1);
		graph.agregarArista(0, 2, 5);
		graph.agregarArista(1, 2, 2);
		
		Caminos camino = new Dijkstra(graph, 0, 2);
		assertTrue(camino.distancia(0) == 0);
		assertTrue(camino.distancia(1) == 1);
		assertTrue(camino.distancia(2) == 3);
	}
	
}
