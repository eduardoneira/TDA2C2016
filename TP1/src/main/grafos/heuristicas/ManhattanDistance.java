package grafos.heuristicas;

import grafos.Punto;

public class ManhattanDistance extends HeuristicAlgortithm{

	public ManhattanDistance() {
		super();
	}

	@Override
	public Double heuristic(Punto p) {
		if (this.destination == null) 
			return (double) 0;
		
		Integer deltaX = this.destination.getX() - p.getX();
		Integer deltaY = this.destination.getY() - p.getY();
		return (double) (Math.abs(deltaX) + Math.abs(deltaY));
	}

}
