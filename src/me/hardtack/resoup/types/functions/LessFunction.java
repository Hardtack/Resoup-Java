package me.hardtack.resoup.types.functions;

import java.util.List;

import me.hardtack.resoup.Environment;
import me.hardtack.resoup.Util;
import me.hardtack.resoup.types.Bool;
import me.hardtack.resoup.types.NumberT;
import me.hardtack.resoup.types.Str;
import me.hardtack.resoup.types.Type;

public class LessFunction extends BuiltinFunction {
	public LessFunction(Environment env) {
		super(env, new Str("<"));
	}

	@Override
	public Type call(List<Type> args) {
		Number first = ((NumberT) args.get(0)).getValue();
		for (int i = 1; i < args.size(); i++) {
			Number n = ((NumberT) args.get(1)).getValue();
			if (Util.compare(first, n) >= 0) {
				return new Bool(false);
			}
		}
		return new Bool(true);
	}
}
