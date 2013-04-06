package me.hardtack.resoup.types.functions;

import java.util.List;

import me.hardtack.resoup.Environment;
import me.hardtack.resoup.types.Null;
import me.hardtack.resoup.types.Str;
import me.hardtack.resoup.types.Type;
import me.hardtack.resoup.types.NumberT;

public class ExitFunction extends BuiltinFunction {

	public ExitFunction(Environment env) {
		super(env, new Str("exit"));
	}

	@Override
	public Type call(List<Type> args) {
		int code = 0;
		if (args.size() > 0) {
			code = ((NumberT) args.get(0)).getValue().intValue();
		}
		System.exit(code);
		return new Null();
	}
}
