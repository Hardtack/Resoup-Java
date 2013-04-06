package me.hardtack.resoup;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Lexer {
	private char c;
	private static Set<Character> singleCharTokens = new HashSet<Character>();
	private static Set<Character> quotes = new HashSet<Character>();
	private static char EOF = (char)0xffff;
	static {
		singleCharTokens.add('(');
		singleCharTokens.add(')');
		singleCharTokens.add('`');

		quotes.add('\'');
		quotes.add('"');
	}

	private void skipWhitespaces(InputStreamReader io) throws IOException {
		while (c != EOF) {
			if (!Character.isWhitespace(c)) {
				break;
			}
			c = (char) io.read();
		}
	}

	private String readString(InputStreamReader io, char quote) throws IOException {
		StringBuilder sb = new StringBuilder();
		c = (char)io.read();
		while (c != EOF && c != quote) {
			sb.append(c);
			if (c == '\\'){
				c = (char)io.read();
				if (c == EOF){
					break;
				}
				sb.append(c);
			}
			c = (char)io.read();
		}
		return sb.toString();
	}
	
	private String readSymbol(InputStreamReader io) throws IOException{
		StringBuilder sb = new StringBuilder();
		while(c != EOF){
			if(Character.isWhitespace(c) || singleCharTokens.contains(c) || quotes.contains(c)){
				break;
			}
			sb.append(c);
			c = (char)io.read();
		}
		return sb.toString();
	}

	public List<String> lex(InputStream is) throws IOException {
		InputStreamReader io = new InputStreamReader(is);
		List<String> list = new LinkedList<String>();
		c = (char) io.read();
		skipWhitespaces(io);
		while (c != EOF) {
			if (singleCharTokens.contains(c)) {
				list.add("" + c);
				c = (char) io.read();
			} else if (quotes.contains(c)) {
				char quote = c;
				list.add("" + c);
				list.add(readString(io, quote));
				list.add("" + c);
				c = (char) io.read();
			} else {
				list.add(readSymbol(io));
			}
			skipWhitespaces(io);
		}
		io.close();
		return list;
	}

	public List<String> lex(String s) throws IOException {
		try {
			byte[] bytes = s.getBytes("UTF-8");
			return lex(new ByteArrayInputStream(bytes));
		} catch (UnsupportedEncodingException e) {
			// Cannot be happend
			return null;
		}
	}
}
