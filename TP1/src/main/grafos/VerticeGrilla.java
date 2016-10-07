package grafos;

public class VerticeGrilla {
	private Integer v;
	
	private Punto punto;

	public VerticeGrilla(Integer v, Punto punto) {
		super();
		this.v = v;
		this.punto = punto;
	}

	public Integer getV() {
		return v;
	}

	public void setV(Integer v) {
		this.v = v;
	}

	public Punto getPunto() {
		return punto;
	}

	public void setPunto(Punto punto) {
		this.punto = punto;
	}	
	
}
