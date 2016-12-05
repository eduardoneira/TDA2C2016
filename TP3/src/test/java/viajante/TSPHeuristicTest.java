package viajante;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.TravellingSalesmanParser;

public class TSPHeuristicTest {
	
	 private static final String PATHDIRECTORY = "travellingSalesman/";
	 
	 private static final String SMALL_TEST_FILE = "example4.txt";
	 
	 private static final String MEDIUM_TEST_FILE = "example15.txt";
	 
	 private static final String BIG_TEST_FILE = "example26.txt";
	 
	 private long start;
	 
	 private void tspTest(String file){
		start = System.nanoTime();
		 
		 
		try {
			TravellingSalesmanParser parser = new TravellingSalesmanParser(PATHDIRECTORY + file);

			Integer optimalSol = parser.getDistance();
			Integer aproxSol = parser.getTSPHeuristic().getDistance();

			System.out.println("Optimal min distance: " + optimalSol);
			System.out.println("Heuristic min distance: " + aproxSol);

			assertTrue(aproxSol <= 2 * optimalSol);
			
			System.out.println("Tiempo de ejecucion:" + (System.nanoTime() - start));
			System.out.println("");
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Funca mal  no deberia pinchar");
		}
	 }

	@Test
	public void tspSmallTest() {
		tspTest(SMALL_TEST_FILE);
	}

	@Test
	public void tspMediumTest() {
		tspTest(MEDIUM_TEST_FILE);
	}

	@Test
	public void tspBigTest() {
		tspTest(BIG_TEST_FILE);
	}
}
