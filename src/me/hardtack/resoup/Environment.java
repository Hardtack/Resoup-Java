package me.hardtack.resoup;

import java.util.HashMap;

import me.hardtack.resoup.types.Bool;
import me.hardtack.resoup.types.Null;
import me.hardtack.resoup.types.Symbol;
import me.hardtack.resoup.types.Type;
import me.hardtack.resoup.types.functions.AddFunction;
import me.hardtack.resoup.types.functions.CarFunction;
import me.hardtack.resoup.types.functions.CdrFunction;
import me.hardtack.resoup.types.functions.ConsFunction;
import me.hardtack.resoup.types.functions.DisplayFunction;
import me.hardtack.resoup.types.functions.DivideFunction;
import me.hardtack.resoup.types.functions.ExitFunction;
import me.hardtack.resoup.types.functions.GreaterEqualFuntion;
import me.hardtack.resoup.types.functions.GreaterFunction;
import me.hardtack.resoup.types.functions.IntFunction;
import me.hardtack.resoup.types.functions.LengthFunction;
import me.hardtack.resoup.types.functions.LessEqualFunction;
import me.hardtack.resoup.types.functions.LessFunction;
import me.hardtack.resoup.types.functions.MultiplyFunction;
import me.hardtack.resoup.types.functions.NewlineFunction;
import me.hardtack.resoup.types.functions.ReadFunction;
import me.hardtack.resoup.types.functions.SubstactFunction;
import me.hardtack.resoup.types.macros.BeginMacro;
import me.hardtack.resoup.types.macros.DefineMacro;
import me.hardtack.resoup.types.macros.IfStatement;
import me.hardtack.resoup.types.macros.LambdaMacro;

public class Environment extends HashMap<Symbol, Type> {
	private static final long serialVersionUID = -7826811143230212890L;
	
	public static class NotfoundError extends Error{
		private static final long serialVersionUID = -4535875971966795014L;

		public NotfoundError(Symbol symbol){
			super(symbol.getName());
		}
	}
	
	private static Environment globalEnvironment = null;
	
	synchronized public static Environment getGlobalEnvironment(){
		if (globalEnvironment == null) {
			globalEnvironment = new Environment();
			
			// Builtin functions
			globalEnvironment.put(new Symbol("+"), new AddFunction(globalEnvironment));
			globalEnvironment.put(new Symbol("-"), new SubstactFunction(globalEnvironment));
			globalEnvironment.put(new Symbol("*"), new MultiplyFunction(globalEnvironment));
			globalEnvironment.put(new Symbol("/"), new DivideFunction(globalEnvironment));
			globalEnvironment.put(new Symbol(">"), new GreaterFunction(globalEnvironment));
			globalEnvironment.put(new Symbol(">="), new GreaterEqualFuntion(globalEnvironment));
			globalEnvironment.put(new Symbol("<"), new LessFunction(globalEnvironment));
			globalEnvironment.put(new Symbol("<="), new LessEqualFunction(globalEnvironment));
			globalEnvironment.put(new Symbol("len"), new LengthFunction(globalEnvironment));
			globalEnvironment.put(new Symbol("car"), new CarFunction(globalEnvironment));
			globalEnvironment.put(new Symbol("cdr"), new CdrFunction(globalEnvironment));
			globalEnvironment.put(new Symbol("cons"), new ConsFunction(globalEnvironment));
			globalEnvironment.put(new Symbol("display"), new DisplayFunction(globalEnvironment));
			globalEnvironment.put(new Symbol("eval"), new DisplayFunction(globalEnvironment));
			globalEnvironment.put(new Symbol("newline"), new NewlineFunction(globalEnvironment));
			globalEnvironment.put(new Symbol("read"), new ReadFunction(globalEnvironment));
			globalEnvironment.put(new Symbol("int"), new IntFunction(globalEnvironment));
			globalEnvironment.put(new Symbol("exit"), new ExitFunction(globalEnvironment));
			
			// Macros
			globalEnvironment.put(new Symbol("define"), new DefineMacro());
			globalEnvironment.put(new Symbol("if"), new IfStatement());
			globalEnvironment.put(new Symbol("begin"), new BeginMacro());
			globalEnvironment.put(new Symbol("lambda"), new LambdaMacro());
			
			// Values
			globalEnvironment.put(new Symbol("Null"), new Null());
			globalEnvironment.put(new Symbol("true"), new Bool(true));
			globalEnvironment.put(new Symbol("false"), new Bool(false));
		}
		return globalEnvironment;
	}

	private Environment parent;

	public Environment() {
		this(null);
	}

	public Environment(Environment parent) {
		this.setParent(parent);
	}

	public Environment getParent() {
		return parent;
	}

	public void setParent(Environment parent) {
		this.parent = parent;
	}

	public Type find(Symbol symbol) {
		if (this.containsKey(symbol)) {
			return this.get(symbol);
		} else if (this.parent != null) {
			return this.parent.find(symbol);
		} else {
			throw new NotfoundError(symbol);
		}
	}
}
