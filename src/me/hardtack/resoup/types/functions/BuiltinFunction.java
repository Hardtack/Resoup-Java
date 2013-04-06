package me.hardtack.resoup.types.functions;

import java.util.LinkedList;

import me.hardtack.resoup.Environment;
import me.hardtack.resoup.types.Function;
import me.hardtack.resoup.types.Str;
import me.hardtack.resoup.types.Symbol;


public abstract class BuiltinFunction extends Function {

	public BuiltinFunction(Environment env, Str name) {
		super(new LinkedList<Symbol>(), null, env, name);
	}
	
}
