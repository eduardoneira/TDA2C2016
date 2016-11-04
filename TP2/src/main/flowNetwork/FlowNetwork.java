
package flowNetwork;

import grafos.Digrafo;

public class FlowNetwork extends Digrafo {

	private Integer source;
	private Integer sink;

	public FlowNetwork(int n) {
		super(n);
		this.source = 0;
		this.sink = n-1;
	}

	public void connectFromSource(Integer node, Integer capacity) {
		this.agregarArista(this.source,node,capacity);
	}

	public void connectToSink(Integer node, Integer capacity) {
		this.agregarArista(node,this.sink,capacity);
	}

}
