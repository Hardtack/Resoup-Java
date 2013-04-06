package me.hardtack.resoup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import me.hardtack.resoup.Parser.ParseException;
import me.hardtack.resoup.types.Type;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.print(">>> ");
			String code = br.readLine();

			Lexer lexer = new Lexer();
			Parser parser = new Parser();
			try {
				List<String> lexed = lexer.lex(code);
				Type parsed = parser.parse(lexed);
				Type evaluated = Evaluator.evaluate(parsed,
						Environment.getGlobalEnvironment());
				System.out.println(evaluated);
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
