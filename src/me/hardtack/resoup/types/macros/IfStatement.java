package me.hardtack.resoup.types.macros;

import java.util.List;

import me.hardtack.resoup.Environment;
import me.hardtack.resoup.Evaluator;
import me.hardtack.resoup.types.Bool;
import me.hardtack.resoup.types.Macro;
import me.hardtack.resoup.types.Type;

public class IfStatement extends Macro {

	@Override
	public Type execute(Environment env, List<Type> args) {
		Bool first = (Bool)Evaluator.evaluate(args.get(0),env);
		if (first.getValue()){
			return Evaluator.evaluate(args.get(1), env);
		} else{
			return Evaluator.evaluate(args.get(2), env);
		}
	}

}
