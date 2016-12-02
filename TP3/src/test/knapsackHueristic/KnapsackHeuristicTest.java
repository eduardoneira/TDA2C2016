package knapsackHueristic;

import static org.junit.Assert.*;

import java.util.BitSet;

import org.junit.Test;

import knapsack.KnapsackSolution;
import knapsackHeuristic.KnapsackHeuristicParser;

public class KnapsackHeuristicTest {
	
	private final static String pathDirectory = "resources/knapsack/"; 	// esto lo dejo para tenerlo ordenado local, no se puede subir
	// archivos porque son muy pesados, despues subo algunos nomás

	private final static String pathEssential = "resources/knapsackEssentials/";
	
	private final static String pathHardExamples = "resources/knapsackHard/";
	
	@Test
	public void testSmallInput() {
		try {
			final String filename = "knap_izi.csv";
			
			KnapsackHeuristicParser parser = new KnapsackHeuristicParser(pathEssential + filename);
			
			KnapsackSolution solution = parser.getKnapsack(0).getSolution();
			
			assertEquals(solution.getBestValue(), new Integer(90));
			
			// Bitset solucion
			BitSet resultBitSet = new BitSet(4);
			resultBitSet.set(1);
			resultBitSet.set(3);
			
			assertEquals(solution.getSelected(),resultBitSet);
			assertEquals(solution.getTime(),"0.00");
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Hubo una excepción, se rompe todo");
		}
	}
}
