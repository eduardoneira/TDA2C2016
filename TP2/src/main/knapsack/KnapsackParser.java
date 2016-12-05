package knapsack;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import knapsackHeuristic.Item;
import knapsackHeuristic.KnapsackSolution;
import utils.FileReader;
import utils.Parser;

public class KnapsackParser {
	
	private List<Knapsack> knapsacks;
	
	private List<KnapsackSolution> solutions;
	
	private static final Integer ALLTESTCASES = 0;

	public KnapsackParser(String path) throws FileNotFoundException, IOException {
		super();		
		this.knapsacks = new ArrayList<>();
		this.solutions = new ArrayList<>();
		this.parseFile(path,ALLTESTCASES);		
	}
	
	public KnapsackParser(String path, Integer testCase) throws FileNotFoundException, IOException {
		super();		
		this.knapsacks = new ArrayList<>();
		this.solutions = new ArrayList<>();
		this.parseFile(path,testCase);		
	}
	
	private void parseFile(String path, Integer testCase) throws FileNotFoundException, IOException {
		
		Parser file = new FileReader(path);
		
		Integer currentTestCase = 1;
		
		while( file.readLine() != null) { 					//Hasta no llegar al final del archivo
			String[] n = file.readLine().split(" ");		//Cantidad de items	
			String[] c = file.readLine().split(" ");		//Peso mochila
			String[] z = file.readLine().split(" ");		//Valor óptimo 
			String[] time = file.readLine().split(" ");		//Tiempo 
			
			Integer N = Integer.parseInt(n[1]);
			List<Item> items = new ArrayList<>(N);
			BitSet selected = new BitSet(N);
			
			for(int i = 0; i < N; i++) {
				String[] values = file.readLine().split(",");
				
				items.add(new Item(Integer.parseInt(values[1]),Integer.parseInt(values[2])));
				
				if(values[3].equals("1")) {
					selected.set(i);
				}
				
			}
			
			//Agrego porque es el testCase o porque quiero a todos los testcases
			if (currentTestCase.equals(testCase) || testCase.equals(ALLTESTCASES)) {
				knapsacks.add(new Knapsack(items, Integer.parseInt(c[1])));
				solutions.add(new KnapsackSolution(selected, Integer.parseInt(z[1]), time[1]));
				
				if (currentTestCase.equals(testCase)) {
					break;
				}
			}
			
			//Tengo que leer dos lineas para pasar al siguiente test case
			file.readLine();
			file.readLine();
			
			currentTestCase++;
		}
		
		file.close();
	}	
	
	public Knapsack getKnapsack(Integer id) {
		return this.knapsacks.get(id);
	}
	
	public List<Knapsack> getAllKnapsacks() {
		return this.knapsacks;
	}
	
	public List<KnapsackSolution> getAllSolutions() {
		return this.solutions;
	}
	
}
