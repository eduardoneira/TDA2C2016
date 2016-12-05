package viajante;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.TravellingSalesmanParser;

public class TSPHeuristicTest {
	
	 private static final String PATHDIRECTORY = "travellingSalesman/";

    @Test
    public void tspSmallTest() {
        try {
            String file = "example4.txt";
            TravellingSalesmanParser parser = new TravellingSalesmanParser(PATHDIRECTORY + file);
            
            
            Integer optimalSol = parser.getDistance();
            Integer aproxSol = parser.getTSPHeuristic().getDistance();
            
            System.out.println("Optimal min distance: " + optimalSol);
            System.out.println("Heuristic min distance: " + aproxSol);
            
            assertTrue(aproxSol <= 2*optimalSol);
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("Funca mal  no deberia pinchar");
        }
    }

    @Test
    public void tspMediumTest() {
        try {
            String file = "example15.txt";
            TravellingSalesmanParser parser = new TravellingSalesmanParser(PATHDIRECTORY + file);
            
            
            Integer optimalSol = parser.getDistance();
            Integer aproxSol = parser.getTSPHeuristic().getDistance();
            
            System.out.println("Optimal min distance: " + optimalSol);
            System.out.println("Heuristic min distance: " + aproxSol);
            
            assertTrue(aproxSol <= 2*optimalSol);
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("Funca mal  no deberia pinchar");
        }
    }

    @Test
    public void tspBigTest() {
        try {
            String file = "example26.txt";
            TravellingSalesmanParser parser = new TravellingSalesmanParser(PATHDIRECTORY + file);
            
            
            Integer optimalSol = parser.getDistance();
            Integer aproxSol = parser.getTSPHeuristic().getDistance();
            
            System.out.println("Optimal min distance: " + optimalSol);
            System.out.println("Heuristic min distance: " + aproxSol);
            
            assertTrue(aproxSol <= 2*optimalSol);
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("Funca mal  no deberia pinchar");
        }
    }
}
