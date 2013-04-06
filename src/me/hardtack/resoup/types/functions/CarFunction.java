package me.hardtack.resoup.types.functions;

import java.util.List;

import me.hardtack.resoup.Environment;
import me.hardtack.resoup.types.ListT;
import me.hardtack.resoup.types.Str;
import me.hardtack.resoup.types.Type;

public class CarFunction extends BuiltinFunction {

	public CarFunction(Environment env) {
		super(env, new Str("car"));
	}

	@Override
	public Type call(List<Type> args) {
		ListT list = (ListT) args.get(0);
		return list.get(0);
	}
}
