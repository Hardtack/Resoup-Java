package me.hardtack.resoup.types;

public class Symbol extends Object implements Type, CharSequence {
	private String name;

	public Symbol(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return this.name;
	}

	@Override
	public char charAt(int index) {
		return this.name.charAt(index);
	}

	@Override
	public int length() {
		return this.name.length();
	}

	@Override
	public CharSequence subSequence(int beginIndex, int endIndex) {
		return this.name.subSequence(beginIndex, endIndex);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Symbol) {
			Symbol other = (Symbol)obj;
			return this.name.equals(other.name);
		}
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	@Override
	public String repr() {
		return this.toString();
	}
}
