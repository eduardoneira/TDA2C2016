package dynamicProgramming;

import java.util.BitSet;
import java.util.List;

public class Knapsack {
	
	private List<Item> items;
	private Integer maxWeight;
	private KnapsackSolution solution;
	private Integer id;
	//Must include maxWeight
	private Integer[][] dynamicProgrammingMatrix = new Integer[items.size()][maxWeight+1];
	
	public Knapsack(List<Item> items, Integer maxWeight, Integer id) {
		this.items = items;
		this.maxWeight = maxWeight;
		this.id = id;
		this.solve();
	}
	
	private void solve() { // O(n*w)
		Long startTimer = System.nanoTime();
		
		// init first column
		for (int i = 0; i < items.size(); i++){
			dynamicProgrammingMatrix[i][0] = 0;
		}
		
		//init first row
		for (int w = 1; w <= maxWeight; w++) {
			if (w < items.get(0).getWeight()) {
				dynamicProgrammingMatrix[0][w] = 0;
			} else {
				dynamicProgrammingMatrix[0][w] = items.get(0).getWeight();
			}
		}
		
		for (int i = 1; i < items.size(); i++) {
			Integer currentWeight = items.get(i).getWeight();
			Integer currentValue = items.get(i).getValue();
			for (int w = 1; w <= maxWeight; w++) {				
				if (w < currentWeight){
					dynamicProgrammingMatrix[i][w] = dynamicProgrammingMatrix[i-1][w];
				} else {
					dynamicProgrammingMatrix[i][w] = this.max(currentValue + dynamicProgrammingMatrix[i-1][w-currentWeight], dynamicProgrammingMatrix[i-1][w]);
				}
			}
		}
		
		this.buildSolution(System.nanoTime() - startTimer);
	}
	
	private Integer max(Integer a, Integer b) {
		return (a > b) ? a : b;
	}
	
	private void buildSolution(Long time) {
		BitSet selected = new BitSet(items.size());
		
		Integer w = maxWeight + 1;
		for (int i = items.size()-1; i >= 0; i--){
			if (!dynamicProgrammingMatrix[i][w].equals(dynamicProgrammingMatrix[i-1][w])) {
				selected.set(i);
				w -= items.get(i).getWeight();
			}
		}
		
		this.solution = new KnapsackSolution(selected, dynamicProgrammingMatrix[items.size()][maxWeight+1], time);
	}
	
	private KnapsackSolution getSolution() {
		return this.solution;
	}
	
}
