package caminoMinimo;

import static org.junit.Assert.*;

import org.junit.Test;

import grafos.FactoryGrilla;
import grafos.Grilla;
import grafos.heuristicas.ManhattanDistance;
import grafos.heuristicas.NullHeuristic;
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
		FactoryGrilla factory  =  new FactoryGrilla(4, 3, true);
		
		factory.agregarColumna(0);
		factory.agregarColumna(2);
		factory.agregarFila(3);
		
		Grilla grilla = factory.createGrilla();
		
		Caminos camino = new HeuristicSearch(grilla, 6, 2, new ManhattanDistance());
		
		assertTrue(camino != null);
		
		assertEquals(camino.distancia(0),new Double(2),0.0000001);
		assertEquals(camino.distancia(2),new Double(6),0.0000001);
		assertEquals(camino.distancia(3),new Double(1),0.0000001);
		assertEquals(camino.distancia(5),new Double(5),0.0000001);
		assertEquals(camino.distancia(6),new Double(0),0.0000001);
		assertEquals(camino.distancia(8),new Double(4),0.0000001);
		assertEquals(camino.distancia(9),new Double(1),0.0000001);
		assertEquals(camino.distancia(10),new Double(2),0.0000001);
		assertEquals(camino.distancia(11),new Double(3),0.0000001);
		
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
		
		Caminos camino = new HeuristicSearch(grilla, 8, 11, new NullHeuristic());
		
		assertTrue(camino != null);
	}
	

}
