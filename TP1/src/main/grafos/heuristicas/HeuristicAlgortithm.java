package grafos.heuristicas;

import grafos.Punto;

/**
 * @author Edu
 * Clase que encapsula algoritmos que usen heuristicas
 */
public abstract class HeuristicAlgortithm implements Heuristic{
	
	protected Punto destination;
	
	public HeuristicAlgortithm() {
		super();
	}
	
	public Punto getDestination() {
		return destination;
	}

	public void setDestination(Punto destination) {
		this.destination = destination;
	}
	
	public Double distanceToDestination(Punto p) {
		return (this.destination != null ) ? this.distance(p, this.destination) : null;
	}
	

}
