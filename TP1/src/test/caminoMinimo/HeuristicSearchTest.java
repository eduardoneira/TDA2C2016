package caminoMinimo;

import static org.junit.Assert.*;

import org.junit.Test;

import grafos.FactoryGrilla;
import grafos.Grilla;
import grafos.heuristicas.ManhattanDistance;
import grafos.recorridos.Caminos;
import grafos.recorridos.HeuristicSearch;

//TODO : hacer un test posta y una mejor manera de generar caminos, estaba re duro cuando hice esto
public class HeuristicSearchTest {

	@Test
	public void compilaTest() {
		Grilla graph = this.generarTodosLosCaminos();
		
		Caminos camino = new HeuristicSearch(graph, 0, 8, new ManhattanDistance());
		
		assertTrue(camino != null);
	}
	
	private Grilla generarTodosLosCaminos(){
		FactoryGrilla factory  =  new FactoryGrilla(3, 3, true);
		
		factory.hacerGrafoCompletoPesosRandom();
		
		return factory.createGrilla();
	}
	
	@Test
	public void obstaculoEnElMedio() {
		FactoryGrilla factory  =  new FactoryGrilla(3, 3, true);
		
		factory.agregarColumna(0);
		factory.agregarColumna(2);
		factory.agregarFila(2);
		
		Grilla grilla = factory.createGrilla();
		
		Caminos camino = new HeuristicSearch(grilla, 3, 2, new ManhattanDistance());
		
		assertTrue(camino != null);
	}
	
	@Test
	public void aVerQueFlasheas() {
		FactoryGrilla factory  =  new FactoryGrilla(4, 4, true);
		
		factory.agregarColumna(0);
		factory.agregarColumna(3);
		factory.agregarFila(0);
		factory.agregarFila(3);
		factory.agregarColumna(1, 0, 1);
		factory.agregarFila(1, 0, 1);
		
		Grilla grilla = factory.createGrilla();
		
		Caminos camino = new HeuristicSearch(grilla, 8, 11, new ManhattanDistance());
		
		assertTrue(camino != null);
	}
	

}
