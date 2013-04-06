package me.hardtack.resoup.types.functions;

import java.util.List;

import me.hardtack.resoup.Environment;
import me.hardtack.resoup.types.ListT;
import me.hardtack.resoup.types.NumberT;
import me.hardtack.resoup.types.Str;
import me.hardtack.resoup.types.Type;

public class LengthFunction extends BuiltinFunction {

	public LengthFunction(Environment env) {
		super(env, new Str("len"));
	}

	@Override
	public Type call(List<Type> args) {
		ListT list = (ListT)args.get(0);
		return new NumberT(list.size());
	} 
}
