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
	
	private Map<TreeNode, Double> distanceToMST;
	
	//heap que devuelve el nodo mas cercano al MST
	private Queue<TreeNode> minHeap;
	
	
	public MSTGenerator(){
		distanceToMST = new HashMap<TreeNode, Double>();
	}
	
	public void primMST(Digrafo g, TreeNode root){
		Set<TreeNode> mst = new HashSet<TreeNode>();
		
		minHeap = new PriorityQueue<TreeNode>(new Comparator<TreeNode>() {
			@Override
			public int compare(TreeNode u, TreeNode v) {
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
			TreeNode node = new TreeNode(u);
			node.setParent(null);
			updateDistanceToMST(node, INFINITY);
		}
		
		updateDistanceToMST(root, 0d);
		
		while(mst.size() < g.n()){
			TreeNode u = minHeap.poll();
			for (Integer ady : g.adyacentes(u.getId())){
				TreeNode v = new TreeNode(ady);
				Integer distUV = g.arista(u.getId(), v.getId()).getWeight();
				if(!mst.contains(v) && (distUV <  distanceToMST.get(v))){
					if(v.getParent() != null){
						v.getParent().getChilds().remove(v);
					}
					v.setParent(u);
					u.getChilds().add(v);
					updateDistanceToMST(v, distUV.doubleValue());
				}
			}
		}
		
	}
	
	private void updateDistanceToMST(TreeNode node, Double newDistance){
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
