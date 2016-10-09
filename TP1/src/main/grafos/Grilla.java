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
		
	private Map<Integer,VerticeGrilla> mapaVertices;
	
	private Heuristic distancia;
	
	private static final double MAXDISTANCEEDGE = Math.sqrt(2);
	
	/**
	 * @param n : numero de vertices
	 * @param rectangular : define si pueden o no haber aristas diagonales
	 */
	public Grilla(int n, boolean permitirAristasDiagonales) {
		super(n);				
		this.crearGrillaBase(this.encontrarNDeGrilla(n), n);
		if (permitirAristasDiagonales) { 
			this.distancia = new EuclideanDistance();
		} else {
			this.distancia = new ManhattanDistance();
		}
	}
	
	private int encontrarNDeGrilla(int vertices){
		boolean encontreN2 = false;
		int n2 = 0;
		
		while (!encontreN2){
			n2++;
			if (Math.pow(n2, 2) >= vertices){
				encontreN2 = true;
			}
		}
		return n2;
	}
	
	//Con los vertices que tiene trata de crear algo parecido a una grilla cuadrada
	private void crearGrillaBase(int n, int vertices){
		
		this.mapaVertices = new HashMap<>();
		
		int x = 0;
		int y = 0;
		
		for (int i = 0; i < vertices; i++){
			
			this.mapaVertices.put(i,new VerticeGrilla(i, new Punto(x, y)));
			x++;
			
			if (x % n == 0){
				x = 0;
				y++;
			}
		}
	}
	
	public void agregarArista(Integer src, Integer dst, int weight){
		if (this.sonAdyacentes(src, dst)) {
			super.agregarArista(src, dst, weight);
		}
	}
	
	private boolean sonAdyacentes(int src, int dst){
		Punto puntoSrc = mapaVertices.get(src).getPunto();
		Punto puntoDst = mapaVertices.get(dst).getPunto();
		
		return (this.distancia.distance(puntoSrc, puntoDst) <= MAXDISTANCEEDGE);
	}
	
	public VerticeGrilla getVerticeGrilla(Integer v){
		return this.mapaVertices.get(v);
	}
	
	public Punto getPuntoDeVertice(Integer v){
		return this.getVerticeGrilla(v).getPunto();
	}
}
