package knapsackHeuristic;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class KnapsackHeuristic {
	
	private List<Item> items;
	private List<Item> itemsAux;
	private Integer maxWeight;
	private Integer sumOfValues;
	private KnapsackSolution solution;

	private int[][] dynamicProgrammingMatrix;
	
	public KnapsackHeuristic(List<Item> items, Integer maxWeight) {
		this.items = items;
		this.itemsAux = new ArrayList<>(items);
		this.maxWeight = maxWeight;
		
		this.sumOfValues = 0;
		
		for (Item item : items) {
			this.sumOfValues += item.getValue();
		}
		
		this.dynamicProgrammingMatrix = new int[items.size()+1][sumOfValues+1];

		Long startTimer = System.nanoTime();
		this.solve();
		long finalTime = System.nanoTime() - startTimer;
		System.out.println("Tardo "+finalTime);
		this.buildSolution(finalTime);
	}
	
	public KnapsackHeuristic(List<Item> items, Integer maxWeight, double epsilon, Integer maxV) {
		this.items = items;
		this.itemsAux = new ArrayList<>();
		this.maxWeight = maxWeight;
		
		this.sumOfValues = 0;
		
		for (Item item : this.items) {
			itemsAux.add(new Item((int)item.getValue(),(int)item.getWeight()));
			item.setValue((int) Math.floor((double) item.getValue() / (double)(epsilon * maxV / (items.size()))));
			this.sumOfValues += item.getValue();
		}
		
		this.dynamicProgrammingMatrix = new int[items.size()+1][sumOfValues+1];

		Long startTimer = System.nanoTime();
		this.solve();
		long finalTime = System.nanoTime() - startTimer;
		System.out.println("Tardo "+finalTime);
		this.buildSolution(finalTime);
	}
	
	
	// Algoritmo de http://math.mit.edu/~goemans/18434S06/knapsack-katherine.pdf
	private void solve() {

		Integer max = 0;
		
		for (int i = 1; i <= items.size();i++){
			int currentWeight = items.get(i-1).getWeight();
			int currentValue = items.get(i-1).getValue();
			
			for (int v = 1; v <= max+currentValue; v++){
				if (v > max) {
					this.dynamicProgrammingMatrix[i][v] = currentWeight + this.dynamicProgrammingMatrix[i-1][Math.max(0, v-currentValue)];
				} else {
					this.dynamicProgrammingMatrix[i][v] = Math.min(dynamicProgrammingMatrix[i-1][v], currentWeight+ dynamicProgrammingMatrix[i-1][Math.max(0, v-currentValue)]);
				}
			}
			
			max += currentValue;
			
		}
	}

	private void buildSolution(Long time) {
		Integer bestValue = null;
		BitSet bitset = new BitSet();
		
		for (int j = this.sumOfValues; j >= 0; j--){
			if (this.dynamicProgrammingMatrix[this.items.size()][j] <= this.maxWeight && bestValue == null){
					bestValue = 0;
					for (int i = this.items.size(); i > 0; i--) {
						if (this.dynamicProgrammingMatrix[i][j] != this.dynamicProgrammingMatrix[i-1][j]){
							bitset.set(i);
							bestValue += itemsAux.get(i-1).getValue();
							j-=items.get(i-1).getValue();
						}
					}
					break;
			}
		}

		this.solution = new KnapsackSolution(bitset, bestValue, time);
	}
	
	public KnapsackSolution getSolution() {
		return this.solution;
	}
	
}
