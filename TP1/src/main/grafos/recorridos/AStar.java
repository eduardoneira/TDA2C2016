package grafos.recorridos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import grafos.Arista;
import grafos.Digrafo;
import grafos.Grilla;
import grafos.VerticeGrilla;
import grafos.heuristicas.ManhattanDistance;

public class AStar extends Caminos {
	
	public AStar(Digrafo g, Integer origen, Integer destino) {
		super(g, origen, destino);
	}

	@Override
	protected void calcularDistancias() {
		
		// arreglar esta garcha
		HeuristicSearch heuristica = new HeuristicSearch((Grilla)this.g, this.src, this.dest, new ManhattanDistance()); // TODO: ver que heuristica usar

		Double[] gScore = new Double[this.g.n()]; // costos reales = g
		Double[] fScore = new Double[this.g.n()]; // costos reales + heuristica = f

		Arrays.fill(gScore, Double.POSITIVE_INFINITY);
		Arrays.fill(fScore, Double.POSITIVE_INFINITY);
		
		ArrayList<Integer> nodosEvaluados = new ArrayList<Integer>();
		Queue<Integer> nodosPorEvaluar = new PriorityQueue<Integer>(); // TODO: cambiar el compare de la cola segun el valor de F
								
		Integer actual;
		nodosPorEvaluar.add(this.src);
		this.dist[this.src] = 0;
		
		fScore[this.src] = heuristica.distancia(src);
		gScore[this.src] = 0.0;

		while (!nodosPorEvaluar.isEmpty()) {
			actual = nodosPorEvaluar.poll(); // saca el nodo con menor fScore
			if (actual == this.dest) {
				// Termino
				System.out.println("LLEGUE A DESTINO :D");
				return;
			}			
			nodosEvaluados.add(actual);
				
			// Agrega todos los adyacentes al actual a la lista por evaluar
			for (Integer vecino : g.adyacentes(actual)) {
				if (nodosEvaluados.contains(vecino))
					continue;
					
				Double tentativeGScore = gScore[actual] + this.g.arista(actual, vecino).getWeight();

				if (!nodosPorEvaluar.contains(vecino)) {
					// Descubri nuevo nodo
					nodosPorEvaluar.add(vecino);
				} else if (tentativeGScore >= gScore[vecino])
					continue;

				// Este es el mejor camino
				gScore[vecino] = tentativeGScore;
				fScore[vecino] = gScore[vecino] + heuristica.distancia(vecino);
				this.edge[vecino] = new Arista(actual, vecino, this.g.arista(actual, vecino).getWeight());
				this.dist[vecino] = this.dist[actual] + this.g.arista(actual, vecino).getWeight();
			}
		}
	}
}



