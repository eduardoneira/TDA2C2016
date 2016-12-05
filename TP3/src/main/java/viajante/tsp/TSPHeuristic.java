package viajante.tsp;

import java.util.ArrayList;
import java.util.List;

import viajante.grafo.Digrafo;
import viajante.mst.MSTGenerator;
import viajante.mst.TreeNode;

public class TSPHeuristic {
	
	private List<Integer> path;
	
	private Integer distance;
	
	private Digrafo g;
	
	public TSPHeuristic(Digrafo g){
		path = new ArrayList<Integer>();
		distance = 0;
		this.g= g;
		
		//Un vertice de g (se que todos tienen un vertice 0)
		TreeNode root = new TreeNode(0);
		
		MSTGenerator mstGenerator = new MSTGenerator();
		mstGenerator.primMST(g, root);
		preorder(root);
		
		//Al final del camino se vuelve a root
		path.add(root.getId());
		
		
		calculateDistance();
		
		/* Cormen
		 
		1 select a vertex r from G.V to be a "root" vertex.
		2 compute a minimum spanning tree T for G from root r using MST-PRIM(G, c, r)
		3 let H be a list of vertices, ordered according to when they are first visited 
		in a preorder tree walk of T
		4 return the hamiltonian cycle H
		*/
		
	}

	private void calculateDistance() {
		Integer previous = null;
		for (Integer v : path){
			if(previous != null){
				distance += g.arista(previous, v).getWeight();
			}
			previous = v;
		}
	}

	private void preorder(TreeNode root) {
		path.add(root.getId());
		for (TreeNode child : root.getChilds()){
			preorder(child);
		}
	}
	
	public List<Integer> getPath(){
		return path;
	}

	public Integer getDistance(){
		return distance;
	}
	
}
