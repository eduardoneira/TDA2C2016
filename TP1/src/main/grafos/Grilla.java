package grafos;

import java.util.HashMap;
import java.util.Map;

import grafos.heuristicas.EuclideanDistance;
import grafos.heuristicas.Heuristic;
import grafos.heuristicas.ManhattanDistance;

/**
 * @author eduardo.neira
 * Grilla para hacer los algoritmos de heuristicas
 */
//TODO: ver si se puede mejorar, hacer un refactor
public class Grilla extends Digrafo{
		
	private Map<Integer,Punto> mapaVertices;
	
	private Heuristic distancia;
	
	private Integer filas;
	
	private Integer columnas;
	
	private static final double MAXDISTANCE = Math.sqrt(2);
	
	/**
	 * @param n : numero de filas
	 * @param m : numero de columnas
	 * @param permitirAristasDiagonales : define si pueden o no haber aristas diagonales
	 */
	public Grilla(int n,int m, boolean permitirAristasDiagonales){
		super(n*m);
		this.filas = n;
		this.columnas = m;
		this.crearGrillaBase();
		if (permitirAristasDiagonales) { 
			this.distancia = new EuclideanDistance();
		} else {
			this.distancia = new ManhattanDistance();
		}
	}
	
	private void crearGrillaBase(){
		
		this.mapaVertices = new HashMap<>();		
		
		for (int x = 0; x < this.columnas; x++){
			for (int y = 0; y < this.filas; y++){
				int verticeActual = x+(y*this.columnas);
				this.mapaVertices.put(verticeActual, new Punto(x, y));
			}
		}
	}
	
	public void agregarArista(Integer src, Integer dst, int weight){
		if (this.sonAdyacentes(src, dst)) {
			super.agregarArista(src, dst, weight);
		}
	}
	
	public void agregarArista(Punto src, Punto dst, int weight){
		if (this.distancia.distance(src, dst) <= MAXDISTANCE) {
			int verticeSrc = src.getX() + (src.getY()*this.columnas);
			int verticeDst = dst.getX() + (dst.getY()*this.columnas);
			super.agregarArista(verticeSrc, verticeDst, weight);
		}
	}
	
	private boolean sonAdyacentes(int src, int dst){
		Punto puntoSrc = mapaVertices.get(src);
		Punto puntoDst = mapaVertices.get(dst);
		
		return (this.distancia.distance(puntoSrc, puntoDst) <= MAXDISTANCE);
	}
	

	public Punto getPuntoDeVertice(Integer v){
		return this.mapaVertices.get(v);
	}
	
	
}
