package grafos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Digrafo implements Iterable<Integer>{
	
	protected Set<Integer> v;
	protected Set<Arista> e;
	//Estas dos estructuras van a estar para que sea O(1) conseguir los nodos y aristas adyacenter aunque sacrificando mucho espacio.
	//Ver si se puede mejorar
	protected Map<Integer,Set<Arista>> adyacentEdges;
	protected Map<Integer,Set<Integer>> adyacentNodes;
	
	/**
	 * Inicializa digrafo con n vertices.
	 * @param n
	 */
	public Digrafo(int n){
		this.v = new HashSet<Integer>();
		this.e = new HashSet<Arista>();
		this.adyacentEdges = new HashMap<>();
		this.adyacentNodes = new HashMap<>();
		
		for (int i = 0; i < n; i++){
			this.v.add(new Integer(i));
			this.adyacentEdges.put(i, new HashSet<Arista>());
			this.adyacentNodes.put(i, new HashSet<Integer>());
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
		return this.adyacentNodes.get(v);
	}

	/**
	 * 
	 * @param v
	 * @return conjunto de aristas adyacentes a v.
	 */
	public Set<Arista> aristasAdyacentes(Integer v){
		return adyacentEdges.get(v);
	}
	
	public void agregarArista(Integer src, Integer dst, int weight){
		Arista edge = new Arista(src, dst, weight);
		adyacentNodes.get(src).add(dst);
		adyacentEdges.get(src).add(edge);
		e.add(edge);
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
	
	public Arista arista(Integer src, Integer dst){
		for (Arista arista : aristasAdyacentes(src)){
			if (arista.getDst().equals(dst)){
				return arista;
			}
		}
		return null;
	}
	
}
