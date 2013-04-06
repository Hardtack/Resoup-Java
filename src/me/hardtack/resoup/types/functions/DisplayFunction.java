package me.hardtack.resoup.types.functions;

import java.util.List;

import me.hardtack.resoup.Environment;
import me.hardtack.resoup.types.Null;
import me.hardtack.resoup.types.Str;
import me.hardtack.resoup.types.Type;

public class DisplayFunction extends BuiltinFunction {
	public DisplayFunction(Environment env) {
		super(env, new Str("display"));
	}
	
	@Override
	public Type call(List<Type> args) {
		System.out.print(args.get(0));
		return new Null();
	}
}
