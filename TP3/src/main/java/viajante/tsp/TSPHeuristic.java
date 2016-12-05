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
		
		//Tomo el vertice 0 del grafo como root.
		TreeNode root = new TreeNode(0);
		
		MSTGenerator mstGenerator = new MSTGenerator();
		mstGenerator.primMST(g, root);
		preorder(root);
		
		//Al final del camino se vuelve a root
		path.add(root.getId());
		
		
		calculateDistance();
		
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
