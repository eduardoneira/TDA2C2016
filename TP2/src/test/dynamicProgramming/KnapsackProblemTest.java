package dynamicProgramming;

import static org.junit.Assert.*;

import java.util.List;
import java.util.BitSet;

import org.junit.Test;


import utils.Directory;

public class KnapsackProblemTest {
	
	private final static String pathDirectory = "resources/knapsack/"; 	// esto lo dejo para tenerlo ordenado local, no se puede subir
																		// archivos porque son muy pesados, despues subo algunos nomás
	
	private final static String pathEssential = "resources/knapsackEssentials/";
	
	
//	@Test
//	public void testParser() {
//		try {
//			final String filename = "knapPI_1_50_1000.csv";
//			KnapsackParser parser = new KnapsackParser(pathEssential + filename);
//			
//			List<KnapsackSolution> solutions = parser.getAllSolutions();
//			
//			assertEquals(solutions.get(0).getBestValue(),new Integer(8373));
//			assertEquals(solutions.get(0).getTime(),"0.00");
//			
//			assertEquals(solutions.get(99).getBestValue(),new Integer(23271));
//			assertEquals(solutions.get(99).getTime(),"0.00");
//			
//			assertEquals(solutions.size(), 100);
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail("Hubo una excepción, se rompe todo vieja");
//		}
//	}
	
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
