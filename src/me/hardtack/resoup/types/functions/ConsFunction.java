package me.hardtack.resoup.types.functions;

import java.util.List;

import me.hardtack.resoup.Environment;
import me.hardtack.resoup.types.ListT;
import me.hardtack.resoup.types.Str;
import me.hardtack.resoup.types.Type;


public class ConsFunction extends BuiltinFunction {

	public ConsFunction(Environment env) {
		super(env, new Str("cons"));
	}
	
	@Override
	public Type call(List<Type> args) {
		Type first = args.get(0);
		ListT second = (ListT) args.get(1);
		ListT list = new ListT(second);
		list.add(0, first);
		return list;
	}
}
