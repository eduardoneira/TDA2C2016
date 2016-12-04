package viajante;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import utils.TravellingSalesmanParser;

public class TSPHeuristicTest {
	
	 private static final String PATHDIRECTORY = "travellingSalesman/";

    @Test
    public void smallTest() {
        try {
            String file = "example4.txt";
            TravellingSalesmanParser parser = new TravellingSalesmanParser(PATHDIRECTORY + file);
            
            System.out.println("Optimal min distance: " + parser.getDistance());
            System.out.println("Heuristic min distance: " + parser.getTSPHeuristic().getDistance());
            assertEquals(parser.getDistance(),parser.getTSPHeuristic().getDistance());	            
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("Funca mal  no deberia pinchar");
        }
    }
	
}
