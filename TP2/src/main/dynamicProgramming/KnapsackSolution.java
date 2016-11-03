package dynamicProgramming;

import java.util.BitSet;

public class KnapsackSolution {
	private BitSet selected;
	private Integer bestValue;
	//Tiene que ser siempre a dos decimales
	private String time; 						
	
	public KnapsackSolution(BitSet selected, Integer bestValue, String time) {
		super();
		this.selected = selected;
		this.bestValue = bestValue;
		this.time = time;
	}
	
	public KnapsackSolution(BitSet selected, Integer bestValue, Long time) {
		super();
		this.selected = selected;
		this.bestValue = bestValue;
		this.setTime(time);;
	}
	
	public BitSet getSelected() {
		return selected;
	}
	public void setSelected(BitSet selected) {
		this.selected = selected;
	}
	public Integer getBestValue() {
		return bestValue;
	}
	public void setBestValue(Integer bestValue) {
		this.bestValue = bestValue;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setTime(Double time){
		this.time = String.format("%.2f",Math.round(time*100.0)/100.0);
	}
	//El tiempo tiene que ser nanosegundos
	public void setTime(Long time){ 			
		//TODO: checkear esto
		double seconds = (double)time / 10000000.0;
		String aux = String.valueOf(seconds);
		this.time = aux.substring(0,1) + "." + aux.substring(1);
	}
	
	
}
