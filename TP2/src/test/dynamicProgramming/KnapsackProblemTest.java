package dynamicProgramming;

import static org.junit.Assert.*;

import java.util.List;
import java.util.BitSet;

import org.junit.Test;

import knapsack.Knapsack;
import knapsack.KnapsackParser;
import knapsack.KnapsackSolution;
import utils.Directory;

public class KnapsackProblemTest {
	
	private final static String pathDirectory = "resources/knapsack/"; 	// esto lo dejo para tenerlo ordenado local, no se puede subir
																		// archivos porque son muy pesados, despues subo algunos nomás
	
	private final static String pathEssential = "resources/knapsackEssentials/";
	
	
	@Test
	public void testSmallCoefficient() {
		try {
			final String filename = "knapPI_1_50_1000.csv";
			KnapsackParser parser = new KnapsackParser(pathEssential + filename);
			
			List<KnapsackSolution> solutions = parser.getAllSolutions();
			List<Knapsack> knapsacks = parser.getAllKnapsacks();
			
			for (int i = 0; i < solutions.size(); i++) {
				assertEquals(solutions.get(i).getBestValue(),knapsacks.get(i).getSolution().getBestValue());
			}

		} catch (Exception e) {
			e.printStackTrace();
			fail("Hubo una excepción, se rompe todo vieja");
		}
	}
	
	@Test
	public void testSmallInput() {
		try {
			final String filename = "knap_izi.csv";
			
			KnapsackParser parser = new KnapsackParser(pathEssential + filename);
			
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
			fail("Hubo una excepción, se rompe todo vieja");
		}
	}
	
	@Test
	public void listFilesDirectory(){
		List<String> files = Directory.listFilesFrom(pathEssential);
		assertTrue(files.size() > 0);
	}
}
