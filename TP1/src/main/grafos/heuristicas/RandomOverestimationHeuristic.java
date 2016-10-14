package grafos.heuristicas;

import java.util.Random;

import grafos.Punto;

public class RandomOverestimationHeuristic extends ManhattanDistance {
	
	private Random random;
	
	private Integer boundRandom = 10;
	
	 public RandomOverestimationHeuristic() {
		super();
		this.random = new Random();
	}
	 
	public void setBoundRandom(Integer bound){
		this.boundRandom = bound;
	}
	
	@Override
	public Double distance(Punto a, Punto b) {
		return super.distance(a, b) + random.nextInt(this.boundRandom);
	}

}
