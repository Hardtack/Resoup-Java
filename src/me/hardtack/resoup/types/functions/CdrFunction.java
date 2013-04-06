package me.hardtack.resoup.types.functions;

import java.util.List;

import me.hardtack.resoup.Environment;
import me.hardtack.resoup.types.ListT;
import me.hardtack.resoup.types.Str;
import me.hardtack.resoup.types.Type;

public class CdrFunction extends BuiltinFunction {
	public CdrFunction(Environment env) {
		super(env, new Str("cdr"));
	}

	@Override
	public Type call(List<Type> args) {
		ListT list = (ListT) args.get(0);
		ListT rv = new ListT();
		for (int i = 1; i < list.size(); i++) {
			rv.add(list.get(i));
		}
		return rv;

	}
}
