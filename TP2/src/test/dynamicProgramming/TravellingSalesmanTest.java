package dynamicProgramming;

import static org.junit.Assert.*;

import org.junit.Test;

import travellingSalesman.TravellingSalesmanParser;

public class TravellingSalesmanTest {

	 private static final String PATHDIRECTORY = "resources/travellingSalesman/";

	    @Test
	    public void iziTest() {
	        try {
	            String file = "example.txt";
	            TravellingSalesmanParser parser = new TravellingSalesmanParser(PATHDIRECTORY + file);
	            
	            assertEquals(parser.getDistance(),parser.getTravellingSalesman().getMinDistance());	            
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            fail("Funca mal  no deberia pinchar");
	        }
	    }
	    
	    @Test
	    public void reallyIziTest() {
	        try {
	            String file = "example17.txt";
	            
	            TravellingSalesmanParser parser = new TravellingSalesmanParser(PATHDIRECTORY + file);	            
	                        
	            //assertEquals(parser.getDistance(),parser.getTravellingSalesman().getMinDistance());	 	            
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            fail("Funca mal  no deberia pinchar");
	        }
	    }
}
