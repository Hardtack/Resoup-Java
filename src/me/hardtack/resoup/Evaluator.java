package me.hardtack.resoup;

import me.hardtack.resoup.types.Function;
import me.hardtack.resoup.types.ListT;
import me.hardtack.resoup.types.Macro;
import me.hardtack.resoup.types.Null;
import me.hardtack.resoup.types.Quote;
import me.hardtack.resoup.types.Symbol;
import me.hardtack.resoup.types.Type;

public class Evaluator {
	public static Type evaluate(Type object, Environment env) {
		if (object instanceof Quote) {
			Quote v = (Quote) object;
			return v.getValue();
		} else if (object instanceof Symbol) {
			Symbol s = (Symbol) object;
			return env.find(s);
		} else if (object instanceof ListT) {
			ListT list = (ListT) object;
			if (list.size() == 0) {
				return new Null();
			}
			Type first = evaluate(list.get(0), env);
			if (first instanceof Function) {
				Function f = (Function) first;
				ListT args = new ListT();
				for (int i = 1; i < list.size(); i++) {
					args.add(evaluate(list.get(i), env));
				}
				return f.call(args);
			} else if (first instanceof Macro) {
				Macro m = (Macro) first;
				ListT args = new ListT();
				for (int i = 1; i < list.size(); i++) {
					args.add(list.get(i));
				}
				return m.execute(env, args);
			} else {
				throw new Error(String.format("%s is not callable", first));
			}
		} else {
			return object;
		}
	}
}
