package me.hardtack.resoup.types;

public class Null implements Type {
	@Override
	public String toString() {
		return "(NULL)";
	}
	@Override
	public String repr() {
		return "";
	}
}
