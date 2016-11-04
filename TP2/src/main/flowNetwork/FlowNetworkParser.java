package flowNetwork;

import utils.FileReader;
import utils.Parser;

import java.io.IOException;

public class FlowNetworkParser {

    private FordFulkerson algorithm;
    private String path;

    public FlowNetworkParser(String path) throws IOException {
        this.path = path;
        this.parseFile();
    }

    private void parseFile() throws IOException {
        Parser parser = new FileReader(this.path);

        String line;

        while ((line = parser.readLine()) != null) {
            Integer N = Integer.parseInt(line);
            Integer M = Integer.parseInt(parser.readLine());

            FlowNetwork network = new FlowNetwork(N+M+2);

            for (int i = 0; i < N; i++) {
                Integer node = i+1; // Tengo que sumar el source
                network.connectFromSource(node,Integer.parseInt(parser.readLine())); // TODO: ver como sacar hardcodeo
            }

            for (int i = 0; i < M; i++) {
                Integer node = N+ i + 1; // Tengo encuenta a source y los N vertices anteriores
                String[] splited = parser.readLine().split(" ");
                network.connectToSink(1+N+i,Integer.parseInt(splited[0]));

                for ( int j = 1; i < splited.length; j++) {
                    Integer src = 1 + Integer.parseInt(splited[j]); // De nuevo tengo el source en cuenta
                    network.agregarArista(src,node,Integer.MAX_VALUE);
                }
            }

            this.algorithm = new FordFulkerson(network);
        }

    }
	
}
