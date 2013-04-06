package me.hardtack.resoup;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import me.hardtack.resoup.types.ListT;
import me.hardtack.resoup.types.Null;
import me.hardtack.resoup.types.NumberT;
import me.hardtack.resoup.types.Quote;
import me.hardtack.resoup.types.Str;
import me.hardtack.resoup.types.Symbol;
import me.hardtack.resoup.types.Type;

public class Parser {
	public static class ParseException extends Exception {
		public ParseException(String string) {
			super(string);
		}

		private static final long serialVersionUID = 913376235144598634L;
	}

	private Queue<String> tokenQueue;

	private Type readList(String close) throws ParseException {
		ListT list = new ListT();
		if (this.tokenQueue.isEmpty()) {
			throw new ParseException("Bracket not closed");
		}

		while (!this.tokenQueue.isEmpty() && !this.tokenQueue.peek().equals(")")) {
			list.add(readItem());
		}

		if (this.tokenQueue.isEmpty()) {
			throw new ParseException("Bracket not closed");
		}

		this.tokenQueue.poll();

		return list;
	}
	
	private Type readStr(String quote) throws ParseException{
		if (this.tokenQueue.size() < 2) {
			throw  new ParseException("String not closed");
		}
		String body = this.tokenQueue.poll();
		this.tokenQueue.poll();
		return new Str(body);
	}

	private Type readItem() throws ParseException {
		if (this.tokenQueue.isEmpty()) {
			return new Null();
		}
		String token = this.tokenQueue.poll();
		if (token.equals("(")){
			return this.readList(")");
		} else if(token.equals("\"") || token.equals("'")){
			return this.readStr(token);
		} else if (token.equals("`")){
			return new Quote(this.readItem());
		} else if (Util.isInteger(token)){
			return new NumberT(Integer.parseInt(token));
		} else if (Util.isDouble(token)){
			return new NumberT(Double.parseDouble(token));
		} else {
			return new Symbol(token);
		}
	}
	
	public Type parse(List<String> tokens) throws ParseException{
		this.tokenQueue = new LinkedBlockingQueue<String>(tokens);
		return this.readItem();
	}
}
