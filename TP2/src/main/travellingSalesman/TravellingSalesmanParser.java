package travellingSalesman;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import utils.FileReader;
import utils.Parser;

public class TravellingSalesmanParser {
	
	private TravellingSalesman ts;
	
	private List<Integer> minPath;
	
	private Integer distance;
	
	public TravellingSalesmanParser(String path) throws IOException {
		this.minPath = new ArrayList<>();
		this.distance = 0;
		this.parseFile(path);
	}
	
	
	/**
	 * El archivo tiene que ser como el siguiente : 
	 * 	Vertice de Salida :
	 *	1
	 *	Cantidad de Vertices :
	 * 	15
	 * 	Costos :
	 *	c0 	...	c15
	 *	..		..
	 *	..		..
	 *	C15 ... Cc15
	 *	Solucion :
	 *	v1
	 *	..
	 *	..	
	 *	v15
	 * */
	private void parseFile(String path) throws IOException {
		
		Parser file = new FileReader(path);		
		
		file.readLine(); // Leo algo al dope
		
		Integer v = Integer.parseInt(file.readLine());
		
		file.readLine(); // Leo algo al dope
		
		Integer N = Integer.parseInt(file.readLine());
		
		Integer[][] costs = new Integer[N][N];
		
		file.readLine(); // Leo algo al dope
		
		for (int i = 0; i < N; i++) {
			String[] splited = file.readLine().split(" ");
			int index = 0;
			for (int j = 0; j < N; j++,index++) {
				while(splited[index].equals(" ") || splited[index].equals("")) {
					index++;
				}
				costs[i][j] = Integer.parseInt(splited[index].trim());
			}
		}
		
		this.ts = new TravellingSalesman(costs, v);
		
		file.readLine(); // Leo algo al dope
		
		for (int i = 0; i < N; i++) {
			this.minPath.add(Integer.parseInt(file.readLine().trim()));
			if (i > 0) {
				this.distance += costs[this.minPath.get(i)-1][this.minPath.get(i-1)-1];
			}
		}
		
		this.minPath.add(v);
		this.distance += costs[this.minPath.get(N)-1][this.minPath.get(N-1)-1];
	}
	
	public TravellingSalesman getTravellingSalesman() {
		return this.ts;
	}


	public List<Integer> getMinPath() {
		return minPath;
	}

	public Integer getDistance() {
		return distance;
	}	
	
}
