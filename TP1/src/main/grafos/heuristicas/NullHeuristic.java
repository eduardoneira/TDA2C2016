package grafos.heuristicas;

import grafos.Punto;

public class NullHeuristic extends HeuristicAlgortithm {

	public NullHeuristic() {
		super();
	}

	@Override
	public Double heuristic(Punto p) {
		return (double) 0;
	}

}
