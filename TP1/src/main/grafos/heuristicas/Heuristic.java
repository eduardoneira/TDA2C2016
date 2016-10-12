package grafos.heuristicas;

import grafos.Punto;

/**
 * @author Edu
 * 
 */
public interface Heuristic {
	Double distanceToDestination(Punto p);
	
	Double distance(Punto a, Punto b);
}
