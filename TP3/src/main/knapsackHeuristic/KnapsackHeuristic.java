package knapsackHeuristic;

import java.util.BitSet;
import java.util.List;

import knapsack.Item;
import knapsack.KnapsackSolution;

public class KnapsackHeuristic {
	
	private List<Item> items;
	private Integer maxWeight;
	private Integer sumOfValues;
	private KnapsackSolution solution;

	private Integer[][] dynamicProgrammingMatrix;
	
	public KnapsackHeuristic(List<Item> items, Integer maxWeight) {
		this.items = items;
		this.maxWeight = maxWeight;
		
		this.sumOfValues = 0;
		
		for (Item item : items) {
			this.sumOfValues += item.getValue();
		}
		
		this.dynamicProgrammingMatrix = new Integer[items.size()+1][sumOfValues+1];

		Long startTimer = System.nanoTime();
		this.solve();
		this.buildSolution(System.nanoTime() - startTimer);
	}
	
	private void solve() {

		for (int i = 0; i <= items.size(); i++){
			dynamicProgrammingMatrix[i][0] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i <= sumOfValues; i++){
			dynamicProgrammingMatrix[0][i] = Integer.MAX_VALUE;
		}
		
		for (int i = 1; i <= items.size(); i++) {
			Integer currentWeight = items.get(i).getWeight();
			Integer currentValue = items.get(i).getValue();			
				
			for (int v = 1; v <= sumOfValues; v++) {				
				if (v < sumOfValues){
					dynamicProgrammingMatrix[i][v] = currentWeight + dynamicProgrammingMatrix[i-1][v];
				} else {
					dynamicProgrammingMatrix[i][v] = Math.min(dynamicProgrammingMatrix[i-1][v], currentWeight + dynamicProgrammingMatrix[i-1][Math.max(0, v - currentValue)]);
				}
			}
		}
	}
	
	private void buildSolution(Long time) {
		BitSet selected = new BitSet(items.size());
		
		Integer max = this.sumOfValues;
		for (int i = items.size(); i > 0; i--){
			if (!dynamicProgrammingMatrix[i][max].equals(dynamicProgrammingMatrix[i-1][max])) {
				selected.set(i);
				max -= items.get(i).getValue();
			}
		}
		
		this.solution = new KnapsackSolution(selected, dynamicProgrammingMatrix[items.size()][max], time);
		System.out.println("Problema resuelto en "+this.solution.getTime()+" para mochila de peso "+this.maxWeight+" con "+this.items.size()+" items"+" y value " + this.solution.getBestValue());
		System.out.println("Sumatoria de Values :" + this.sumOfValues);
	}
	
	public KnapsackSolution getSolution() {
		return this.solution;
	}
	
}
