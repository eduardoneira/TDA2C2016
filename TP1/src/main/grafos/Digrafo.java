package grafos;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Digrafo implements Iterable<Integer>{
	
	private Set<Integer> v;
	private Set<Arista> e;
	
	/**
	 * Inicializa digrafo con n vertices.
	 * @param n
	 */
	public Digrafo(int n){
		this.v = new HashSet<Integer>();
		this.e = new HashSet<Arista>();
		
		for (int i = 0; i < n; i++){
			this.v.add(new Integer(i));
		}
	}
	
	/**
	 * 
	 * @return cantidad de vertices
	 */
	public int n(){
		return v.size();
	}
	

	/**
	 * 
	 * @return cantidad de aristas
	 */
	public int m(){
		return e.size();
	}

	/**
	 * 
	 * @param v
	 * @return conjunto de vertices adyacentes a v.
	 */
	public Set<Integer> adyacentes(Integer v){
		//TODO
		return null;
	}

	/**
	 * 
	 * @param v
	 * @return conjunto de aristas adyacentes a v.
	 */
	public Set<Arista> aristasAdyacentes(Integer v){
		//TODO
		return null;
	}
	
	public void agregarArista(Integer src, Integer dst, int weight){
		e.add(new Arista(src, dst, weight));
	}
	
	@Override
	public Iterator<Integer> iterator(){
		return v.iterator();
	}
	
	/**
	 * 
	 * @return conjunto de vertices del grafo.
	 */
	public Set<Integer> v(){
		return v;
	}
	
	/**
	 * 
	 * @return conjunto de aristas del grafo.
	 */
	public Set<Arista> e(){
		return e;
	}
	
}
