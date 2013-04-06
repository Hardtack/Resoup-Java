package me.hardtack.resoup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import me.hardtack.resoup.types.Null;
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
			int bcount = 0;
			String code = "";
			while (true) {
				String line = br.readLine();
				for (int i = 0; i < line.length(); i++) {
					char c = line.charAt(i);
					if (c == '(') {
						bcount++;
					} else if (c == ')') {
						bcount--;
					}
				}
				code += line;
				if (bcount > 0) {
					code += '\n';
					continue;
				}
				break;
			}

			Lexer lexer = new Lexer();
			Parser parser = new Parser();
			try {
				List<String> lexed = lexer.lex(code);

				Type parsed = parser.parse(lexed);
				Type evaluated = Evaluator.evaluate(parsed,
						Environment.getGlobalEnvironment());
				if (!(evaluated instanceof Null)) {
					System.out.println(evaluated.repr());
				}
			} catch (Exception e) {
				e.printStackTrace();
			} catch (Error e) {
				e.printStackTrace();
			}
		}
	}

}
