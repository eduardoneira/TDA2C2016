package grafos;

public class Arista {

	private Integer src;
	private Integer dst;
	private Integer weight;
	private Integer capacity;
	private Integer flow;

	public Arista(Integer src, Integer dst, Integer wc) {
		this.src = src;
		this.dst = dst;
		this.weight = wc;
		this.capacity = wc;
		this.flow = 0;
	}
	
	public Integer getSrc() {
		return src;
	}

	public Integer getDst() {
		return dst;
	}

	public int getWeight() {
		return weight;
	}

	public Integer getCapacity() {
		return this.capacity;
	}

	public void setFlow(Integer flujo) {
		this.flow = flujo;	
	}

	public Integer getFlow() {
		return this.flow;
	}

}
