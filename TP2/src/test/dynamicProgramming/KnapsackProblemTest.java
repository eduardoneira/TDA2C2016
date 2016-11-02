package dynamicProgramming;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class KnapsackProblemTest {
	
	private final static String pathDirectory = "resources/knapsack/"; 	// esto lo dejo para tenerlo ordenado local, no se puede subir
																		// archivos porque son muy pesados, despues subo algunos nomás
	
	@Test
	public void testParser() {
		try {
			final String filename = "knapPI_1_50_1000.csv";
			KnapsackParser parser = new KnapsackParser(pathDirectory + filename);
			
			List<KnapsackSolution> solutions = parser.getAllSolutions();
			
			assertEquals(solutions.get(0).getBestValue(),new Integer(8373));
			assertEquals(solutions.get(0).getTime(),"0.00");
			
			assertEquals(solutions.get(99).getBestValue(),new Integer(23271));
			assertEquals(solutions.get(99).getTime(),"0.00");
			
			assertEquals(solutions.size(), 100);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Hubo una excepción, se rompe todo vieja");
		}
	}
}
