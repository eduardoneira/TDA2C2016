package grafos.recorridos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
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

		Grilla grilla = (Grilla) this.g;
		HeuristicSearch heuristica = new HeuristicSearch(grilla, this.src, this.dest, new ManhattanDistance()); // TODO: ver que heuristica usar

		Double[] gScore = new Double[this.g.n()]; // costos reales
		Double[] fScore = new Double[this.g.n()]; // costos reales + heuristica = f

		Arrays.fill(gScore, Double.POSITIVE_INFINITY);
		Arrays.fill(fScore, Double.POSITIVE_INFINITY);
		
		ArrayList<VerticeGrilla> nodosEvaluados = new ArrayList<VerticeGrilla>();
		Queue<VerticeGrilla> nodosPorEvaluar = new PriorityQueue<VerticeGrilla>(new Comparator<VerticeGrilla>() {
			@Override
			// Compara segun el valor de F
			public int compare(VerticeGrilla u, VerticeGrilla v) {
				if (fScore[u.getV()] < fScore[v.getV()]) {
					return -1;
				} else if (fScore[u.getV()] > fScore[v.getV()]) {
					return +1;
				} else {
					return 0;
				}
			}
		});
		nodosPorEvaluar.add(grilla.getVerticeGrilla(this.src));
		
		VerticeGrilla actual;
		fScore[this.src] = heuristica.distancia(src);
		gScore[this.src] = 0.0;

		while (!nodosPorEvaluar.isEmpty()) {
			actual = nodosPorEvaluar.poll(); // saca el nodo con menor fScore
			if (actual.getV() == this.dest) {
				// TODO: aca reconstruir el camino
				System.out.println("LLEGUE A DESTINO :D");
			}			
			nodosEvaluados.add(actual);

			// Agrega todos los adyacentes al actual a la lista por evaluar
			for (Integer vecino : g.adyacentes(actual.getV())) {
				if (nodosEvaluados.contains(grilla.getVerticeGrilla(vecino)))
					continue;

				Double tentativeGScore = gScore[actual.getV()] + this.g.arista(actual.getV(), vecino).getWeight();

				if (!nodosPorEvaluar.contains(grilla.getVerticeGrilla(vecino))) {
					// Descubri nuevo nodo
					nodosPorEvaluar.add(grilla.getVerticeGrilla(vecino));
				} else if (tentativeGScore >= gScore[vecino])
					continue;

				// Este es el mejor camino
				gScore[vecino] = tentativeGScore;
				fScore[vecino] = gScore[vecino] + heuristica.distancia(vecino);
			}

		}
	}
}


/*WIKI*/
//function A*(start, goal)
//// The set of nodes already evaluated.
//closedSet := {}
//// The set of currently discovered nodes still to be evaluated.
//// Initially, only the start node is known.
//openSet := {start}
//// For each node, which node it can most efficiently be reached from.
//// If a node can be reached from many nodes, cameFrom will eventually contain the
//// most efficient previous step.
//cameFrom := the empty map
//
//// For each node, the cost of getting from the start node to that node.
//gScore := map with default value of Infinity
//// The cost of going from start to start is zero.
//gScore[start] := 0 
//// For each node, the total cost of getting from the start node to the goal
//// by passing by that node. That value is partly known, partly heuristic.
//fScore := map with default value of Infinity
//// For the first node, that value is completely heuristic.
//fScore[start] := heuristic_cost_estimate(start, goal)
//
//while openSet is not empty
//    current := the node in openSet having the lowest fScore[] value
//    if current = goal
//        return reconstruct_path(cameFrom, current)
//
//    openSet.Remove(current)
//    closedSet.Add(current)
//    for each neighbor of current
//        if neighbor in closedSet
//            continue		// Ignore the neighbor which is already evaluated.
//        // The distance from start to a neighbor
//        tentative_gScore := gScore[current] + dist_between(current, neighbor)
//        if neighbor not in openSet	// Discover a new node
//            openSet.Add(neighbor)
//        else if tentative_gScore >= gScore[neighbor]
//            continue		// This is not a better path.
//
//        // This path is the best until now. Record it!
//        cameFrom[neighbor] := current
//        gScore[neighbor] := tentative_gScore
//        fScore[neighbor] := gScore[neighbor] + heuristic_cost_estimate(neighbor, goal)
//
//return failure
//
//function reconstruct_path(cameFrom, current)
//total_path := [current]
//while current in cameFrom.Keys:
//    current := cameFrom[current]
//    total_path.append(current)
//return total_path


