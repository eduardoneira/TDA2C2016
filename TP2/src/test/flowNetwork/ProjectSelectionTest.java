package flowNetwork;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 * Created by eduu on 04/11/16.
 */
public class ProjectSelectionTest {

    private static final String PATHDIRECTORY = "resources/flowNetwork/";

    @Test
    public void parserTest() {
        try {
            String file = "example.txt";
            ProjectSelectionParser parser = new ProjectSelectionParser(PATHDIRECTORY + file);
                        
            FlowNetwork network = parser.getAlgorithm().getNetwork();
            
            assertEquals(network.n(), 7);
            assertEquals(network.m(), 8);
            
            assertEquals(parser.maxProfit(), new Integer(1));
            

        } catch (Exception e) {
            e.printStackTrace();
            fail("Funca mal vieja no deberia pinchar");
        }
    }
    
}
