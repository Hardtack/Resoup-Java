package me.hardtack.resoup.types;

public class Quote implements Type {
	private Type value;

	public Type getValue() {
		return value;
	}

	public void setValue(Type value) {
		this.value = value;
	}

	public Quote(Type value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "`" + this.value.toString();
	}
	
	@Override
	public String repr() {
		return this.toString();
	}
}
