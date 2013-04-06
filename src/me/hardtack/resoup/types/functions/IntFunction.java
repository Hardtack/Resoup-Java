package me.hardtack.resoup.types.functions;

import java.util.List;

import me.hardtack.resoup.Environment;
import me.hardtack.resoup.types.NumberT;
import me.hardtack.resoup.types.Str;
import me.hardtack.resoup.types.Type;

public class IntFunction extends BuiltinFunction {

	public IntFunction(Environment env) {
		super(env, new Str("int"));
	}

	@Override
	public Type call(List<Type> args) {
		Str str = (Str) args.get(0);
		try {
			return new NumberT(Integer.parseInt(str.getValue()));
		} catch (Exception e) {
			return args.get(1);
		}
	}

}
