package me.hardtack.resoup.types;

import java.util.List;

import me.hardtack.resoup.Environment;
import me.hardtack.resoup.Evaluator;

public class Function implements Type {
	private List<Symbol> argSymbols;
	private Type body;
	private Environment env;
	private Str name;

	public List<Symbol> getArgSymbols() {
		return argSymbols;
	}

	public void setArgSymbols(List<Symbol> argSymbols) {
		this.argSymbols = argSymbols;
	}

	public Type getBody() {
		return body;
	}

	public void setBody(Type body) {
		this.body = body;
	}

	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

	public Str getName() {
		return name;
	}

	public void setName(Str name) {
		this.name = name;
	}

	public Function(List<Symbol> argSymbols, Type body, Environment env,
			Str name) {
		this.argSymbols = argSymbols;
		this.body = body;
		this.env = env;
		this.name = name;
	}

	public Function(List<Symbol> argSymbols, Type body, Environment env) {
		this(argSymbols, body, env, new Str("¥ë"));

	}

	public Type call(List<Type> args) {
		Environment newEnv = new Environment(this.env);
		for (int i = 0; i < this.argSymbols.size(); i++) {
			Symbol symbol = this.argSymbols.get(i);
			Type arg = args.get(i);
			newEnv.put(symbol, arg);
		}
		return Evaluator.evaluate(body, newEnv);
	}

	@Override
	public String toString() {
		return String.format("<Function(%s)>", this.name);
	}

	@Override
	public String repr() {
		return this.toString();
	}
}
