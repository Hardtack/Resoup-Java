package me.hardtack.resoup.types.functions;

import java.util.List;

import me.hardtack.resoup.Environment;
import me.hardtack.resoup.types.Str;
import me.hardtack.resoup.types.Type;

public class EvalFunction extends BuiltinFunction {

	public EvalFunction(Environment env) {
		super(env, new Str("eval"));
	}
	
	@Override
	public Type call(List<Type> args) {
		return args.get(0);
	}

}
