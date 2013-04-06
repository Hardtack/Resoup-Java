package me.hardtack.resoup.types;

public class Str implements Type, CharSequence {
	private String value;

	public Str(String value) {
		this.value = value;
	}

	@Override
	public char charAt(int index) {
		return this.value.charAt(index);
	}

	@Override
	public int length() {
		return this.value.length();
	}

	@Override
	public CharSequence subSequence(int beginIndex, int endIndex) {
		return this.value.subSequence(beginIndex, endIndex);
	}
	
	@Override
	public String toString() {
		String repr = new String(this.value);
		repr.replace("\"", "\\\"");
		return '"'+repr+'"';
	}

}
