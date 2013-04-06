package me.hardtack.resoup.types.functions;

import java.util.List;

import me.hardtack.resoup.Environment;
import me.hardtack.resoup.Util;
import me.hardtack.resoup.types.NumberT;
import me.hardtack.resoup.types.Str;
import me.hardtack.resoup.types.Type;

public class AddFunction extends BuiltinFunction {

	public AddFunction(Environment env) {
		super(env, new Str("+"));
	}
	
	@Override
	public Type call(List<Type> args) {
		NumberT result = new NumberT(0);
		for(Type arg:args){
			NumberT num  = (NumberT)arg;
			result = new NumberT(Util.add(result.getValue(), num.getValue()));
		}
		return result;
	}
}
