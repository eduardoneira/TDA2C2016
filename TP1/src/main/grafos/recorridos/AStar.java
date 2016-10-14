package grafos.recorridos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import grafos.Arista;
import grafos.Digrafo;
import grafos.Grilla;
import grafos.heuristicas.HeuristicAlgortithm;

public class AStar extends Caminos {

	public AStar(Digrafo g, Integer origen, Integer destino, HeuristicAlgortithm heuristica) {
		super(g, origen, destino, heuristica);
	}

	@Override
	protected void calcularDistancias() {

		Grilla grilla = (Grilla) this.g;
		Double[] gScore = new Double[this.g.n()]; // costos reales = g
		Double[] fScore = new Double[this.g.n()]; // costos reales + heuristica
													// = f
		Arrays.fill(gScore, Double.POSITIVE_INFINITY);
		Arrays.fill(fScore, Double.POSITIVE_INFINITY);

		ArrayList<Integer> nodosEvaluados = new ArrayList<Integer>();
		Queue<Integer> nodosPorEvaluar = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer u, Integer v) {
				if (fScore[u] < fScore[v]) {
					return -1;
				} else if (fScore[u] > fScore[v]) {
					return +1;
				} else {
					return 0;
				}
			}
		});

		heuristica.setDestination(grilla.getPuntoDeVertice(this.dest));
		nodosPorEvaluar.add(this.src);

		fScore[this.src] = heuristica.distanceToDestination(grilla.getPuntoDeVertice(src));
		gScore[this.src] = 0.0;

		Integer actual;

		while (!nodosPorEvaluar.isEmpty()) {
			actual = nodosPorEvaluar.poll(); // saca el nodo con menor fScore
			if (actual == this.dest) {
				return;
			}
			nodosEvaluados.add(actual);

			// Agrega todos los adyacentes al actual a la lista por evaluar
			for (Integer vecino : g.adyacentes(actual)) {
				if (nodosEvaluados.contains(vecino))
					continue;

				Double tentativeGScore = gScore[actual] + this.g.arista(actual, vecino).getWeight();

				if (tentativeGScore >= gScore[vecino])
					continue;

				if (!nodosPorEvaluar.contains(vecino)) {
					// Este es el mejor camino
					gScore[vecino] = tentativeGScore;
					fScore[vecino] = gScore[vecino]
							+ heuristica.distanceToDestination(grilla.getPuntoDeVertice(vecino));
					this.edge[vecino] = new Arista(actual, vecino, this.g.arista(actual, vecino).getWeight());
					this.dist[vecino] = this.dist[actual] + this.g.arista(actual, vecino).getWeight();

					nodosPorEvaluar.add(vecino);

				} else if (vecino == this.dest) {
					this.edge[vecino] = new Arista(actual, vecino, this.g.arista(actual, vecino).getWeight());
					this.dist[vecino] = this.dist[actual] + this.g.arista(actual, vecino).getWeight();
				}
			}
		}
		return; // No llega a destino
	}
}
