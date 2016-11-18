package flowNetwork;

import utils.FileReader;
import utils.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import grafos.Arista;

public class ProjectSelectionParser {

    private FordFulkerson algorithm;
    private Set<Integer> selectedProjects;
    private Set<Integer> selectedWorkers;
    private Integer maxProfit;
    private List<Set<Integer>> projects;
    private String path;

    public ProjectSelectionParser(String path) throws IOException {
        this.path = path;
        this.selectedProjects = new HashSet<>();
        this.selectedWorkers = new HashSet<>();
        this.projects = new ArrayList<>();
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
                
                Set<Integer> set = new HashSet<>();
                
                for ( int j = 1; j < splited.length; j++) {
                    Integer dst = Integer.parseInt(splited[j]); 
                    network.agregarArista(node,dst,Integer.MAX_VALUE);
                    set.add(dst);
                }
                
                projects.add(set);
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
            
            for ( int i = 0; i < projects.size(); i++) {
            	Set<Integer> s = projects.get(i);
            	boolean elegido = true;
            	
            	for (Integer r : s) {
            		if (!selectedWorkers.contains(r)){
            			elegido = false;
            			break;
            		}
            	}
            	
            	if (elegido && !selectedProjects.contains(i+1)) {
            		this.selectedProjects.add(i+1);
            		Arista edge =  network.arista(0, N+i+1);
              		maxProfit += edge.getCapacity() - edge.getFlow();
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
