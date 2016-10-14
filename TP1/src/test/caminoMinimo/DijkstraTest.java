package caminoMinimo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import grafos.Arista;
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
		
		Integer[] caminoHacia1 = {0, 1};
		List<Arista> aristasHacia1 = camino.camino(1);
		
		for (int i = 0; i < aristasHacia1.size(); i++){
			Arista arista = aristasHacia1.get(i);
			assertEquals(arista.getSrc(), caminoHacia1[i]);
			assertEquals(arista.getDst(), caminoHacia1[i + 1]);
		}
	}

	@Test
	public void grafoConDosAristasTest() {
		Digrafo grafo = new Digrafo(3);
		grafo.agregarArista(0, 1, 1);
		grafo.agregarArista(0, 2, 5);
		grafo.agregarArista(1, 2, 2);
		
		Caminos camino = new Dijkstra(grafo, 0, 2);
		assertTrue(camino.distancia(0) == 0);
		assertTrue(camino.distancia(1) == 1);
		assertTrue(camino.distancia(2) == 3);
		
		Integer[] caminoHacia1 = {0, 1};
		List<Arista> aristasHacia1 = camino.camino(1);
		
		for (int i = 0; i < aristasHacia1.size(); i++){
			Arista arista = aristasHacia1.get(i);
			assertEquals(arista.getSrc(), caminoHacia1[i]);
			assertEquals(arista.getDst(), caminoHacia1[i + 1]);
		}
		
		Integer[] caminoHacia2 = {0, 1, 2};
		List<Arista> aristasHacia2 = camino.camino(1);
		
		for (int i = 0; i < aristasHacia2.size(); i++){
			Arista arista = aristasHacia2.get(i);
			assertEquals(arista.getSrc(), caminoHacia2[i]);
			assertEquals(arista.getDst(), caminoHacia2[i + 1]);
		}
	}
	
	@Test
	public void grafoComplejoTest() {
		Digrafo grafo = new Digrafo(7);
		
		grafo.agregarArista(0, 1, 3);
		grafo.agregarArista(0, 2, 5);
		grafo.agregarArista(0, 3, 6);
		
		grafo.agregarArista(1, 3, 2);
		
		grafo.agregarArista(2, 3, 2);
		grafo.agregarArista(2, 4, 6);
		grafo.agregarArista(2, 5, 3);
		grafo.agregarArista(2, 6, 7);
		
		grafo.agregarArista(3, 5, 9);
		
		grafo.agregarArista(4, 6, 2);
		
		grafo.agregarArista(5, 4, 5);
		
		grafo.agregarArista(5, 6, 1);
		
		Caminos camino = new Dijkstra(grafo, 0, 2);
		assertTrue(camino.distancia(0) == 0);
		assertTrue(camino.distancia(1) == 3);
		assertTrue(camino.distancia(2) == 5);
		assertTrue(camino.distancia(3) == 5);
		assertTrue(camino.distancia(4) == 11);
		assertTrue(camino.distancia(5) == 8);
		assertTrue(camino.distancia(6) == 9);
		
		
		Integer[] caminoHacia6 = {0, 2, 5, 6};
		List<Arista> aristasHacia6 = camino.camino(6);
		
		for (int i = 0; i < aristasHacia6.size(); i++){
			Arista arista = aristasHacia6.get(i);
			assertEquals(arista.getSrc(), caminoHacia6[i]);
			assertEquals(arista.getDst(), caminoHacia6[i + 1]);
		}
		
	}
}
