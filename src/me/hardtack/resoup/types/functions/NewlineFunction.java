package me.hardtack.resoup.types.functions;

import java.util.List;

import me.hardtack.resoup.Environment;
import me.hardtack.resoup.types.Null;
import me.hardtack.resoup.types.Str;
import me.hardtack.resoup.types.Type;

public class NewlineFunction extends BuiltinFunction {
	public NewlineFunction(Environment env) {
		super(env, new Str("newline"));
	}

	@Override
	public Type call(List<Type> args) {
		System.out.println();
		return new Null();
	}
}
