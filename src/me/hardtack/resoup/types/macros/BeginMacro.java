package me.hardtack.resoup.types.macros;

import java.util.List;

import me.hardtack.resoup.Environment;
import me.hardtack.resoup.Evaluator;
import me.hardtack.resoup.types.Macro;
import me.hardtack.resoup.types.Null;
import me.hardtack.resoup.types.Type;

public class BeginMacro extends Macro {

	@Override
	public Type execute(Environment env, List<Type> args) {
		Type result = new Null();
		for(Type arg:args){
			result = Evaluator.evaluate(arg, env);
		}
		return result;
	}

}
