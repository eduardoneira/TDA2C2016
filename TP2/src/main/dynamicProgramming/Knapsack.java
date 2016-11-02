package dynamicProgramming;

import java.util.List;

public class Knapsack {
	
	private List<Item> items;
	private Integer maxWeight;
	private KnapsackSolution solution;
	private Integer id;
	
	public Knapsack(List<Item> items, Integer maxWeight, Integer id) {
		this.items = items;
		this.maxWeight = maxWeight;
		this.id = id;
		this.solve();
	}
	
	private void solve(){
		
	}
	
	private KnapsackSolution getSolution() {
		return this.solution;
	}
	
}
