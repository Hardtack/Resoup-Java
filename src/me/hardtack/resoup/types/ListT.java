package me.hardtack.resoup.types;

import java.util.Collection;
import java.util.LinkedList;

public class ListT extends LinkedList<Type> implements Type {
	public ListT() {
		super();
	}

	public ListT(Collection<? extends Type> type) {
		super(type);
	}

	private static final long serialVersionUID = 2377366297721317205L;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("(");
		if (this.size() > 0) {
			for (int i = 0; i < this.size() - 1; i++) {
				sb.append(this.get(i).repr());
				sb.append(" ");
			}
			sb.append(this.get(this.size() - 1).repr());
		}
		sb.append(')');
		return sb.toString();
	}

	@Override
	public String repr() {
		return this.toString();
	}
}
