package me.hardtack.resoup.types;

import java.util.List;

import me.hardtack.resoup.Environment;

public abstract class Macro implements Type {
	public abstract Type execute(Environment env, List<Type> args);
}
