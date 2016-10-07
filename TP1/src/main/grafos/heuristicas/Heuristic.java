package grafos.heuristicas;

import grafos.Punto;

/**
 * @author Edu
 * 
 */
public interface Heuristic {
	Double heuristic(Punto p);
	
	Double distance(Punto a, Punto b);
}
