package viajante.mst;

import java.util.HashSet;
import java.util.Set;

public class TreeNode {
	
	private Integer id;
	
	private TreeNode parent;
	
	private Set<TreeNode> childs;
	
	public TreeNode(Integer id){
		this.id = id;
		this.childs = new HashSet<TreeNode>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public Set<TreeNode> getChilds() {
		return childs;
	}

	public void setChilds(Set<TreeNode> childs) {
		this.childs = childs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreeNode other = (TreeNode) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
