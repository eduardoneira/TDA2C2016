package travellingSalesman;

import static org.junit.Assert.*;

import org.junit.Test;

public class TravellingSalesmanTest {

	 private static final String PATHDIRECTORY = "resources/travellingSalesman/";

	    @Test
	    public void iziTest() {
	        try {
	            String file = "example.txt";
	            TravellingSalesmanParser parser = new TravellingSalesmanParser(PATHDIRECTORY + file);
	            
	            assertEquals(parser.getDistance(),parser.getTravellingSalesman().minDistance);	            
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            fail("Funca mal vieja no deberia pinchar");
	        }
	    }
	    
	    @Test
	    public void reallyIziTest() {
	        try {
	            String file = "exampleIzi.txt";
	            
	            TravellingSalesmanParser parser = new TravellingSalesmanParser(PATHDIRECTORY + file);	            
	                        
	            assertEquals(parser.getDistance(),parser.getTravellingSalesman().minDistance);	 	            
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            fail("Funca mal vieja no deberia pinchar");
	        }
	    }
}
