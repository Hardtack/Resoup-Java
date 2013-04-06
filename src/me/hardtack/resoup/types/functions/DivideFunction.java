package me.hardtack.resoup.types.functions;

import java.util.List;

import me.hardtack.resoup.Environment;
import me.hardtack.resoup.Util;
import me.hardtack.resoup.types.NumberT;
import me.hardtack.resoup.types.Str;
import me.hardtack.resoup.types.Type;

public class DivideFunction extends BuiltinFunction {
	public DivideFunction(Environment env) {
		super(env, new Str("/"));
	}
	
	@Override
	public Type call(List<Type> args) {
		if (args.size() < 2){
			NumberT n = (NumberT)args.get(0);
			return new NumberT(Util.divide(1, n.getValue()));
		}
		NumberT result = new NumberT(((NumberT)args.get(0)).getValue());
		for(int i = 1; i < args.size(); i++){
			NumberT num  = (NumberT)args.get(i);
			result = new NumberT(Util.divide(result.getValue(), num.getValue()));
		}
		return result;
	}
}
