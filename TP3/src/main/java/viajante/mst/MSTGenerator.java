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
	
	//Para saber cuales ya procesamos
	private Set<Integer> mst;
	
	private Map<Integer, Integer> parents;
	private Map<Integer, Set<Integer>> childs;
	
	public MSTGenerator(){
		distanceToMST = new HashMap<Integer, Double>();
		mst = new HashSet<Integer>();
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
		
		while(mst.size() < g.n()){
			Integer u = minHeap.poll();
			if(mst.add(u)){
				for (Integer v : g.adyacentes(u)){
					Integer distUV = g.arista(u, v).getWeight();
					if(!mst.contains(v) && distUV < distanceToMST.get(v)){
						if(parents.get(v) != null){
							childs.get(parents.get(v)).remove(v);
						}
						parents.put(v, u);
						childs.get(u).add(v);
						updateDistanceToMST(v, distUV.doubleValue());
					}
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
		distanceToMST.put(node, newDistance);
		minHeap.add(node);
	}
	
}
