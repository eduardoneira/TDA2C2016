package grafos;

import java.util.HashMap;
import java.util.Map;

import grafos.heuristicas.EuclideanDistance;
import grafos.heuristicas.Heuristic;

//TODO : Refactor a constructor y limitar como agregar aristas. Además revisar si esta bien
public class Grilla extends Digrafo{

	private Map<Integer,VerticeGrilla> grilla;
	//TODO: hacer para que se pueda seleccionar distinto por grilla
	private Heuristic distancia = new EuclideanDistance();
	
	public Grilla(int n) {
		super(n);
		this.grilla = new HashMap<>();
		
		this.crearBaseGrilla(this.encontrarNGrilla(n), n);
	}
	
	private int encontrarNGrilla(int vertices){
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
	
	private void crearBaseGrilla(int n, int vertices){
		
		int x = 0;
		int y = 0;
		
		for (int i = 0; i < vertices; i++){
			
			this.grilla.put(i,new VerticeGrilla(i, new Punto(x, y)));
			x++;
			
			if (x % n == 0){
				x = 0;
				y++;
			}
		}
	}
	
	@Override
	public void agregarArista(Integer src, Integer dst, int weight){
		if (this.sonAdyacentes(src,dst)){
			super.agregarArista(src, dst, weight);
		}
	}
	
	private boolean sonAdyacentes(int src, int dst){
		//TODO : Ver si se puede generalizar
		if (this.distancia.distance(grilla.get(src).getPunto(), grilla.get(dst).getPunto()) <= Math.sqrt(2)){
			return true;
		}
		return false;
	}
	
	public VerticeGrilla getVerticeGrilla(Integer v){
		return this.grilla.get(v);
	}
}
