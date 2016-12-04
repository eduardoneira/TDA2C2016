package viajante.tsp;

import java.util.ArrayList;
import java.util.List;

import viajante.grafo.Digrafo;
import viajante.mst.MSTGenerator;
import viajante.mst.TreeNode;

public class TSPHeuristic {
	
	private List<Integer> path;
	
	public TSPHeuristic(){
		path = new ArrayList<Integer>();
	}
	
	public List<Integer> aproxTSPTour(Digrafo g){
		
		//Un vertice cualquiera de g	
		TreeNode root = new TreeNode(0);
		
		MSTGenerator mstGenerator = new MSTGenerator();
		mstGenerator.primMST(g, root);
		preorder(root);
		return path;
		
		
		/* Cormen
		 
		1 select a vertex r from G.V to be a "root" vertex.
		2 compute a minimum spanning tree T for G from root r using MST-PRIM(G, c, r)
		3 let H be a list of vertices, ordered according to when they are first visited
		in a preorder tree walk of T
		4 return the hamiltonian cycle H
		*/
		
	}

	private void preorder(TreeNode root) {
		path.add(root.getId());
		for (TreeNode child : root.getChilds()){
			preorder(child);
		}
	}
	
	

}
