package grafos;

public class Arista {

	private Integer src;
	private Integer dst;
	private int weight;

	public Arista(Integer src, Integer dst, int weight) {
		this.src = src;
		this.dst = dst;
		this.weight = weight;
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

}
