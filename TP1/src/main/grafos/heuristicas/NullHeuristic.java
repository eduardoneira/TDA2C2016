package grafos.heuristicas;

import grafos.Punto;

public class NullHeuristic extends HeuristicAlgortithm {

	public NullHeuristic() {
		super();
	}

	@Override
	public Double distance(Punto a, Punto b) {
		return (double) 0;
	}

}
