package grafos.heuristicas;

import grafos.Punto;

/**
 * @author Edu
 * Clase que encapsula algoritmos que usen heuristicas
 */
public abstract class HeuristicAlgortithm implements Heuristic{
		
	public HeuristicAlgortithm() {
		super();
	}
	
	protected Punto destination;

	public Punto getDestination() {
		return destination;
	}

	public void setDestination(Punto destination) {
		this.destination = destination;
	}

}
