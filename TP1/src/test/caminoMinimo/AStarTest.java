package caminoMinimo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import grafos.Arista;
import grafos.FactoryGrilla;
import grafos.Grilla;
import grafos.recorridos.AStar;
import grafos.recorridos.Caminos;

public class AStarTest {

	@Test
	public void compilaTest() {
		Grilla graph = this.generarTodosLosCaminos();
		
		Caminos camino = new AStar(graph, 0, 7);
		
		assertTrue(camino != null);
	}
	
	private Grilla generarTodosLosCaminos(){
		FactoryGrilla factory  =  new FactoryGrilla(3, 3, true);
		
		factory.hacerGrafoCompletoPesosRandom();
		
		return factory.createGrilla();
	}
	
	@Test
	public void chiquitoTest(){
		
		Grilla graph = new FactoryGrilla(2, 3, true).createGrilla();
		graph.agregarArista(0, 1, 1);
		graph.agregarArista(0, 2, 1);
		graph.agregarArista(1, 3, 1);
		graph.agregarArista(3, 4, 1);
		graph.agregarArista(2, 5, 1);
		graph.agregarArista(3, 5, 1);
		
		Caminos camino = new AStar(graph, 0, 4);
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
	
	@Test
	public void masChiquitoTest(){
		
		Grilla graph = new FactoryGrilla(2, 2, true).createGrilla();
		graph.agregarArista(0, 1, 1);
		graph.agregarArista(0, 3, 10);
		graph.agregarArista(1, 2, 1);
		graph.agregarArista(2, 3, 1);
		
		Caminos camino = new AStar(graph, 0, 3);
		assertTrue(camino.distancia(0) == 0);
		assertTrue(camino.distancia(1) == 1);
		assertTrue(camino.distancia(2) == 2);
		assertTrue(camino.distancia(3) == 3);
		
		for (int i = 0; i < graph.n() ; i++) {
			assertTrue(camino.camino(i).size() == camino.distancia(i));
		}
		
		Integer[] aristasCaminoMasLarga = new Integer[]{0,1,2,3};
		Integer indice = 0;
		for(Arista arista : camino.camino(aristasCaminoMasLarga[aristasCaminoMasLarga.length - 1])){
			assertTrue(arista.getSrc() == aristasCaminoMasLarga[indice]);
			assertTrue(arista.getDst() == aristasCaminoMasLarga[++indice]);
		}

	}

}
