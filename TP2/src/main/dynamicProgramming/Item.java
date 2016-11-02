package dynamicProgramming;

public class Item {
	
	private Integer value;
	private Integer weight;
	private Boolean selected;
		
	public Item(Integer value, Integer weight, Boolean selected) {
		super();
		this.value = value;
		this.weight = weight;
		this.selected = selected;
	}
	
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Boolean getSelected() {
		return selected;
	}
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	
	
}
