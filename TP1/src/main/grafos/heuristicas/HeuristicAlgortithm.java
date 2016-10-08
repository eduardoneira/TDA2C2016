package grafos.heuristicas;

import java.util.Comparator;

import grafos.Punto;
import grafos.VerticeGrilla;

/**
 * @author Edu
 * Clase que encapsula algoritmos que usen heuristicas
 */
public abstract class HeuristicAlgortithm implements Heuristic, Comparator<VerticeGrilla>{
	
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
	
	public Double heuristic(Punto p) {
		return this.distance(p, this.destination);
	}
	
	public int compare(VerticeGrilla v1, VerticeGrilla v2){
		if (this.heuristic(v1.getPunto()) < this.heuristic(v2.getPunto())) {
			return -1;
		}
		
		if (this.heuristic(v1.getPunto()) < this.heuristic(v2.getPunto()) ){
			return 1;
		}
		
		return 0;
	}	
	

}
