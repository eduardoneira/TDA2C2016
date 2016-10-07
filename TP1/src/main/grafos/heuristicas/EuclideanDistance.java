package grafos.heuristicas;

import grafos.Punto;

public class EuclideanDistance extends HeuristicAlgortithm{

	public EuclideanDistance() {
		super();
	}
	
	@Override
	public Double distance(Punto a, Punto b) {
		if (this.destination == null) 
			return (double) 0;
		
		Double deltaX = (double) (b.getX() - a.getX());
		Double deltaY = (double) (b.getY() - a.getY());
		return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
	}
	

}
