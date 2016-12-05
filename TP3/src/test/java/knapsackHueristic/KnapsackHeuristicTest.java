package knapsackHueristic;

import static org.junit.Assert.*;

import java.util.BitSet;
import java.util.List;

import org.junit.Test;

import knapsackHeuristic.KnapsackHeuristic;
import knapsackHeuristic.KnapsackHeuristicParser;
import knapsackHeuristic.KnapsackSolution;

public class KnapsackHeuristicTest {
	
	private final static String pathDirectory = "resources/knapsack/"; 	// esto lo dejo para tenerlo ordenado local, no se puede subir
	// archivos porque son muy pesados, despues subo algunos nomás

	private final static String pathEssential = "resources/knapsackEssentials/";
	
	private final static String pathHardExamples = "resources/knapsackHard/";
	
//	@Test
//	public void testSmallInput() {
//		try {
//			final String filename = "knap_izi.csv";
//			
//			KnapsackHeuristicParser parser = new KnapsackHeuristicParser(pathEssential + filename, 0.9);
//			
//			KnapsackSolution solution = parser.getKnapsack(0).getSolution();
//			
//			assertEquals(solution.getBestValue(), new Integer(9));
//			
//			// Bitset solucion
//			BitSet resultBitSet = new BitSet();
//			resultBitSet.set(2);
//			resultBitSet.set(4);
//			
//			assertEquals(solution.getSelected(),resultBitSet);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail("Hubo una excepción, se rompe todo");
//		}
//	}
	
	@Test
	public void testHard() {
		try {
			final String filename = "knapPI_11_100_1000.csv";
			KnapsackHeuristicParser parser = new KnapsackHeuristicParser(pathHardExamples + filename,0.9);
			
			List<KnapsackSolution> solutions = parser.getAllSolutions();
			List<KnapsackHeuristic> knapsacks = parser.getAllKnapsacks();
			
			for (int i = 0; i < solutions.size(); i++) {
				System.out.println("Solucion obtenida : "+ knapsacks.get(i).getSolution().getBestValue()+" - Solucion posta : "+solutions.get(i).getBestValue());
				System.out.println((double) knapsacks.get(i).getSolution().getBestValue() / (double) solutions.get(i).getBestValue());
				//assertEquals(solutions.get(i).getBestValue(),knapsacks.get(i).getSolution().getBestValue());
			}

		} catch (Exception e) {
			e.printStackTrace();
			fail("Hubo una excepción, se rompe todo");
		}
	}
}
