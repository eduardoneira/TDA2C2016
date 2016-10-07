package grafos.heuristicas;

import grafos.Punto;

/**
 * @author Edu
 * Clase que encapsula algoritmos que usen heuristicas
 */
public abstract class HeuristicAlgortithm implements Heuristic{
		
	public HeuristicAlgortithm(Punto destination) {
		super();
		this.destination = destination;
	}
	
	protected Punto destination;	
	
}
