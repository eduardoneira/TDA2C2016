package grafos.recorridos;

import java.util.LinkedList;
import java.util.Queue;

import grafos.Arista;

import grafos.Digrafo;

public class BFS extends Caminos {

    public BFS(Digrafo g, Integer origen, Integer destino) {
        super(g, origen, destino);
    }

	@Override
	public void calcularDistancias() {
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(this.src);
		
		while (!queue.isEmpty()){
			Integer current = queue.poll();
			
			for (Integer node : this.g.adyacentes(current)){
				if (!this.visitado(node)) {
					this.dist[node] = this.dist[current] + 1;
					this.edge[node] = new Arista(current, node, -1); // Este BFS va a ignorar el peso, de nuevo me cago en el espacio :o
					queue.offer(node);
				}
			}
		}
			
	}

}