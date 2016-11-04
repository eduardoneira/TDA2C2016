package flowNetwork;

import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Created by eduu on 04/11/16.
 */
public class FlowNetworkTest {

    private static final String PATHDIRECTORY = "resources/flowNetwork/";

    @Test
    public void parserTest() {
        try {
            String file = "example.txt";
            FlowNetworkParser parser = new FlowNetworkParser(PATHDIRECTORY + file);

        } catch (Exception e) {
            e.printStackTrace();
            fail("Funca mal vieja no deberia pinchar");
        }
    }

}
