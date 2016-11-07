package flowNetwork;

import utils.FileReader;
import utils.Parser;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import grafos.Arista;

public class ProjectSelectionParser {

    private FordFulkerson algorithm;
    private Set<Integer> selectedProjects;
    private Set<Integer> selectedWorkers;
    private Integer maxProfit;
    private String path;

    public ProjectSelectionParser(String path) throws IOException {
        this.path = path;
        this.selectedProjects = new HashSet<>();
        this.selectedWorkers = new HashSet<>();
        this.maxProfit = 0;
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
                Integer node = i+1; // Tengo que sumar el source TODO: ver como sacar hardcodeo
                network.connectToSink(node,Integer.parseInt(parser.readLine()));
            }

            for (int i = 0; i < M; i++) {
                Integer node = N+ i + 1; // Tengo encuenta a source y los N vertices anteriores
                String[] splited = parser.readLine().split(" ");
                network.connectFromSource(1+N+i,Integer.parseInt(splited[0]));

                for ( int j = 1; j < splited.length; j++) {
                    Integer dst = Integer.parseInt(splited[j]); 
                    network.agregarArista(node,dst,Integer.MAX_VALUE);
                }
            }

            this.algorithm = new FordFulkerson(network);
            
            //Me fijo que proyectos convienen 
            for (Arista project : network.edgesFromSource()) {
            	if (project.getFlow() < project.getCapacity()) {
            		selectedProjects.add(project.getDst()-N);
            		//Me fijo que chabones contrato
            		for (Integer worker : network.adyacentes(project.getDst())) {
            			selectedWorkers.add(worker);
            		}
            		maxProfit += project.getCapacity() - project.getFlow();
            	}
            }
            
            
       }

    }
    
    public Integer maxProfit() {
    	return this.maxProfit;
    }

    public FordFulkerson getAlgorithm() {
        return this.algorithm;
    }
	
    public Set<Integer> selectedProjects() {
    	return this.selectedProjects;
    }
    
    public Set<Integer> selectedWorkers() {
    	return this.selectedWorkers;
    }
    
}
