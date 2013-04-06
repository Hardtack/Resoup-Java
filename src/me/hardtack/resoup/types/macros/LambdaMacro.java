package me.hardtack.resoup.types.macros;

import java.util.ArrayList;
import java.util.List;

import me.hardtack.resoup.Environment;
import me.hardtack.resoup.types.Function;
import me.hardtack.resoup.types.ListT;
import me.hardtack.resoup.types.Macro;
import me.hardtack.resoup.types.Symbol;
import me.hardtack.resoup.types.Type;

public class LambdaMacro extends Macro {

	@Override
	public Type execute(Environment env, List<Type> args) {
		ListT fargs = (ListT) args.get(0);
		List<Symbol> symbols = new ArrayList<Symbol>();
		for(Type arg:fargs){
			symbols.add((Symbol) arg);
		}
		Type body = args.get(1);
		return new Function(symbols, body, env);
	}

}
