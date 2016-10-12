package grafos;

import java.util.Random;

/*
 * Wrapper rapido para crear grillas un poco más fácil, la verdad se podria hacer mejor pero estamos jugados
 * */
public class FactoryGrilla {
	
	private Grilla grilla;
	
	private int filas;
	
	private int columnas;
	
	private boolean permitirDiagonales;
	
	private final static int MAXWEIGHT = 5;

	public FactoryGrilla(int n, int m, boolean permitirDiagonales) {
		super();
		this.grilla = new Grilla(n,m,permitirDiagonales);
		this.filas = n;
		this.columnas = m;
		this.permitirDiagonales = permitirDiagonales;
	}
		
	public void reset(){
		if (this.grilla != null)
			this.grilla = new Grilla(this.filas,this.columnas,this.permitirDiagonales);
	};
	
	public void hacerGrafoCompletoPesosRandom(){
		if (this.grilla != null) {
			for (int j = 0; j < this.filas; j++) {
				for (int i = 0; i < this.columnas; i++){
					if (i != this.columnas-1) {
						this.grilla.agregarArista(new Punto(i,j), new Punto(i+1,j), new Random().nextInt(MAXWEIGHT));
						this.grilla.agregarArista(new Punto(i+1,j), new Punto(i,j), new Random().nextInt(MAXWEIGHT));
					}
					if (j != this.filas - 1){
						this.grilla.agregarArista(new Punto(i,j), new Punto(i,j+1), new Random().nextInt(MAXWEIGHT));
						this.grilla.agregarArista(new Punto(i,j+1), new Punto(i,j), new Random().nextInt(MAXWEIGHT));
					}
				}
			}
		}
	}
	
	public void agregarColumna(int m, int inicio, int fin){
		if (this.grilla != null)
			for (int i = inicio; i < fin; i++){
				this.grilla.agregarArista(new Punto(m,i), new Punto(m,i+1), new Random().nextInt(MAXWEIGHT));
				this.grilla.agregarArista(new Punto(m,i+1), new Punto(m,i), new Random().nextInt(MAXWEIGHT));
			}
	}
	
	public void agregarFila(int n){
		this.agregarFila(n, 0, this.columnas-1);
	}
	
	public void agregarFila(int n, int inicio, int fin){
		if (this.grilla != null)
			for (int i = inicio; i < fin; i++){
				this.grilla.agregarArista(new Punto(i,n), new Punto(i+1,n), new Random().nextInt(MAXWEIGHT));
				this.grilla.agregarArista(new Punto(i+1,n), new Punto(i,n), new Random().nextInt(MAXWEIGHT));
			}
	}
	
	public void agregarColumna(int m){
		this.agregarColumna(m,0,this.filas-1);
	}
	
	public void agregarArista(Punto src, Punto dst){
		if (this.grilla != null)
			this.grilla.agregarArista(src, dst, new Random().nextInt(MAXWEIGHT));
	}
	
	public void agregarArista(Punto src, Punto dst, int weight){
		if (this.grilla != null)
			this.grilla.agregarArista(src, dst, weight);
	}
	
	
	
	
	public Grilla createGrilla(){
		return this.grilla;
	}	
}
