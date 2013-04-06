package me.hardtack.resoup.types.macros;

import java.util.ArrayList;
import java.util.List;

import me.hardtack.resoup.Environment;
import me.hardtack.resoup.Evaluator;
import me.hardtack.resoup.SyntaxError;
import me.hardtack.resoup.types.Function;
import me.hardtack.resoup.types.ListT;
import me.hardtack.resoup.types.Macro;
import me.hardtack.resoup.types.Null;
import me.hardtack.resoup.types.Str;
import me.hardtack.resoup.types.Symbol;
import me.hardtack.resoup.types.Type;


public class DefineMacro extends Macro {
	@Override
	public Type execute(Environment env, List<Type> args) {
		Type first = args.get(0);
		Type second = args.get(1);
		if(first instanceof ListT){
			ListT list = (ListT)first;
			Symbol fname = (Symbol) list.get(0);
			ListT fargs = new ListT(list.subList(1, list.size()-1));
			List<Symbol> symbols = new ArrayList<Symbol>();
			for(Type farg:fargs){
				symbols.add((Symbol) farg);
			}
			Function func = new Function(symbols, second, env, new Str(fname.getName()));
			env.put(fname, func);
		} else if(first instanceof Symbol){
			env.put((Symbol) first, Evaluator.evaluate(second, env));
		} else{
			throw new SyntaxError("Syntax error : define");
		}
		return new Null();
	}
}
