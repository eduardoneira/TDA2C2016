package grafos.heuristicas;

import grafos.Punto;

public class ManhattanDistance extends HeuristicAlgortithm{

	public ManhattanDistance(Punto destination) {
		super(destination);
	}

	@Override
	public Double heuristic(Punto p) {
		Integer deltaX = this.destination.getX() - p.getX();
		Integer deltaY = this.destination.getY() - p.getY();
		return (double) (Math.abs(deltaX) + Math.abs(deltaY));
	}

}
