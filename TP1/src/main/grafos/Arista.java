package grafos;

public class Arista {

	private int src;
	private int dst;
	private int weight;

	public Arista(int src, int dst, int weight) {
		this.src = src;
		this.dst = dst;
		this.weight = weight;
	}

	public int getSrc() {
		return src;
	}

	public int getDst() {
		return dst;
	}

	public int getWeight() {
		return weight;
	}

}
