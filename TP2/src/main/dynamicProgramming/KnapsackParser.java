package dynamicProgramming;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import utils.FileReader;

public class KnapsackParser {
	
	private List<Knapsack> knapsacks;
	
	private List<KnapsackSolution> solutions;

	public KnapsackParser(String path) throws FileNotFoundException, IOException {
		super();		
		this.knapsacks = new ArrayList<>();
		this.solutions = new ArrayList<>();
		this.parseFile(path);		
	}
	
	private void parseFile(String path) throws FileNotFoundException, IOException {
		
		FileReader file = new FileReader(path);
		
		Integer id = 1;
		
		while( file.readLine() != null) { 					//Hasta no llegar al final del archivo
			String[] n = file.readLine().split(" ");		//Cantidad de items	
			String[] c = file.readLine().split(" ");		//Peso mochila
			String[] z = file.readLine().split(" ");		//Valor �ptimo 
			String[] time = file.readLine().split(" ");		//Tiempo 
			
			Integer N = Integer.parseInt(n[1]);
			List<Item> items = new ArrayList<>(N);
			BitSet selected = new BitSet(N);
			
			for(int i = 0; i < N; i++) {
				String[] values = file.readLine().split(",");
				
				items.add(new Item(Integer.parseInt(values[1]),Integer.parseInt(values[2]),false));
				
				if(values[3].equals("1")) {
					selected.set(i);
				}
				
			}
			
			knapsacks.add(new Knapsack(items, Integer.parseInt(c[1]), id));
			solutions.add(new KnapsackSolution(selected, Integer.parseInt(z[1]), time[1]));
			
			//Tengo que leer dos lineas para pasar al siguiente test case
			file.readLine();
			file.readLine();
			
			id++;
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