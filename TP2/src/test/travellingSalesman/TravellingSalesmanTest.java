package travellingSalesman;

import static org.junit.Assert.*;

import org.junit.Test;

import flowNetwork.FlowNetwork;
import flowNetwork.ProjectSelectionParser;

public class TravellingSalesmanTest {

	 private static final String PATHDIRECTORY = "resources/travellingSalesman/";

	    @Test
	    public void parserTest() {
	        try {
	            String file = "example.txt";
	            TravellingSalesmanParser parser = new TravellingSalesmanParser(PATHDIRECTORY + file);
	                        
	            System.out.println("termine");	            
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            fail("Funca mal vieja no deberia pinchar");
	        }
	    }
}
