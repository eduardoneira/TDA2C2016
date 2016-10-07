package grafos.heuristicas;

import grafos.Punto;

public class EuclideanDistance extends HeuristicAlgortithm{

	public EuclideanDistance() {
		super();
	}

	@Override
	public Double heuristic(Punto p) {
		if (this.destination == null) 
			return (double) 0;
		
		Double deltaX = (double) (destination.getX() - p.getX());
		Double deltaY = (double) (destination.getY() - p.getY());
		return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
	}

}
