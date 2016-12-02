package flowNetwork;

import java.util.LinkedList;
import java.util.Queue;

import grafos.Arista;

public class FordFulkerson {

    private FlowNetwork network;
    private Integer maxFlow;

    public FordFulkerson(FlowNetwork network) {
        this.network = network;
        this.maxFlow = 0;
        this.solve();
    }

    private void solve() {
    	while (true) {
	    	//BFS time    	
	    	Queue<Integer> queue = new LinkedList<>();
	    	queue.offer(network.getSource());
	    	
	    	Arista[] pred = new Arista[network.n()];
	    	
	    	while (!queue.isEmpty()) { //
	    		Integer current = queue.poll();
	    		
				for (Arista edge : network.aristasAdyacentes(current)){
					if (pred[edge.getDst()] == null && edge.getCapacity() > edge.getFlow()) {
						pred[edge.getDst()] = edge;
						queue.offer(edge.getDst());
					}
				}
	    	}
	    	
	    	if (pred[network.getSink()] == null) {
	    		break;
	    	}
	    	
	    	Integer df = Integer.MAX_VALUE;
	    	
	    	for (Arista edge = pred[network.getSink()]; edge != null; edge = pred[edge.getSrc()]) {
	    		df = Math.min(df, edge.getCapacity() - edge.getFlow());
	    	}
	    	
	    	for (Arista edge = pred[network.getSink()]; edge != null; edge = pred[edge.getSrc()]) { 
	    		edge.setFlow(edge.getFlow() + df);
	    	}
	    	
	    	this.maxFlow += df;
	    	
    	}    	
    }

    public FlowNetwork getNetwork() {
        return this.network;
    }

}
