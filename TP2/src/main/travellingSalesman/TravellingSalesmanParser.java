package travellingSalesman;

import java.io.IOException;

import utils.FileReader;
import utils.Parser;

public class TravellingSalesmanParser {
	
	private TravellingSalesman ts;
	
	public TravellingSalesmanParser(String path) throws IOException {
		this.parseFile(path);
	}
	
	
	/**
	 * El archivo tiene que ser como el siguiente : 
	 * 
	 *	1
	 * 	15
	 *	c0 	...	c15
	 *	..
	 *	..
	 *	C15 ... Cc15
	 * */
	private void parseFile(String path) throws IOException {
		
		Parser file = new FileReader(path);		
		
		Integer v = Integer.parseInt(file.readLine());
		
		Integer N = Integer.parseInt(file.readLine());
		
		Integer[][] costs = new Integer[N][N];
		
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
		
	}
	
	public TravellingSalesman getTravellingSalesman() {
		return this.ts;
	}
	
}
