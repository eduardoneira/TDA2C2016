package grafos.heuristicas;

import grafos.Punto;

public class ManhattanDistance extends HeuristicAlgortithm{

	public ManhattanDistance() {
		super();
	}

	@Override
	public Double distance(Punto a, Punto b) {
		if (this.destination == null) 
			return (double) 0;
		
		Integer deltaX = b.getX() - a.getX();
		Integer deltaY = b.getY() - a.getY();
		return (double) (Math.abs(deltaX) + Math.abs(deltaY));
	}

}
