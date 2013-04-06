package me.hardtack.resoup.types;

public class Bool implements Type {
	private boolean value;
	
	public boolean getValue(){
		return this.value;
	}
	
	public void setValue(boolean value){
		this.value = value;
	}
	
	public Bool(boolean value){
		this.value = value;
	}

	@Override
	public String toString() {
		if (this.value) {
			return "#T";
		} else {
			return "#F";
		}
	}
}
