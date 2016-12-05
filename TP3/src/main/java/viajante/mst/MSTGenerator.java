package viajante.mst;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import viajante.grafo.Digrafo;

public class MSTGenerator {

	private static Double INFINITY = Double.POSITIVE_INFINITY;
	
	private Map<Integer, Double> distanceToMST;
	
	//heap que devuelve el nodo mas cercano al MST
	private Queue<Integer> minHeap;
	
	private Map<Integer, Integer> parents;
	private Map<Integer, Set<Integer>> childs;
	
	public MSTGenerator(){
		distanceToMST = new HashMap<Integer, Double>();
		parents = new HashMap<Integer, Integer>();
		childs = new HashMap<Integer, Set<Integer>>();
		
	}
	
	public void primMST(Digrafo g, TreeNode root){
		
		minHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer u, Integer v) {
				if (distanceToMST.get(u) < distanceToMST.get(v)){
					return -1;
				} else if (distanceToMST.get(u) > distanceToMST.get(v)){
					return +1;
				} else {
					return 0;
				}
			}
		});
		
		for (Integer u : g.v()){
			childs.put(u, new HashSet<Integer>());
			parents.put(u, null);
			updateDistanceToMST(u, INFINITY);
		}
		
		updateDistanceToMST(root.getId(), 0d);
		
		while(!minHeap.isEmpty()){
			Integer u = minHeap.poll();
			for (Integer v : g.adyacentes(u)){
				if(v.equals(u)){
					//Salteamos la arista incidente sobre el mismo vertice.
					continue;
				}
				Integer distUV = g.arista(u, v).getWeight();
				if(minHeap.contains(v) && (distUV < distanceToMST.get(v))){
					if(parents.get(v) != null){
						childs.get(parents.get(v)).remove(v);
					}
					parents.put(v, u);
					childs.get(u).add(v);
					updateDistanceToMST(v, distUV.doubleValue());
				}
			}
		}
		
		buildTree(root);
		
	}
	
	private void buildTree(TreeNode root) {
		for (Integer child : childs.get(root.getId())){
			TreeNode nodeChild = new TreeNode(child);
			nodeChild.setParent(root);
			root.getChilds().add(nodeChild);
			buildTree(nodeChild);
		}
		
	}

	private void updateDistanceToMST(Integer node, Double newDistance){
		minHeap.remove(node);
		distanceToMST.put(node, newDistance);
		minHeap.add(node);
	}
	
	
	/* Cormen
	
	MST-Prim(G, w, r):
		for each u in G.V
			u.key = infinite
			u.parent = NIL
		r.key = 0
		Q = G.V
		while !Q.isEmpty:
			u = Q.poll
			for each v in G.Adj(u):
				if v in Q and w(u,v) < v.key
					v.parent = u
					v.key = w(u,v)
	*/
}
