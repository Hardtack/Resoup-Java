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

}
