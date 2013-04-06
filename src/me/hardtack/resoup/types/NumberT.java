package me.hardtack.resoup.types;

public class NumberT implements Type {
	private Number value;

	public Number getValue() {
		return value;
	}

	public void setValue(Number value) {
		this.value = value;
	}
	
	public NumberT(Number value){
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value.toString();
	}
}
