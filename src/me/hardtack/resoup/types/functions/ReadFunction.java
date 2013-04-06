package me.hardtack.resoup.types.functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import me.hardtack.resoup.Environment;
import me.hardtack.resoup.types.Str;
import me.hardtack.resoup.types.Type;

public class ReadFunction extends BuiltinFunction {

	public ReadFunction(Environment env) {
		super(env, new Str("read"));
	}
	
	@Override
	public Type call(List<Type> args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		try {
			line = br.readLine();
		} catch (IOException e) {
		}
		return new Str(line);
	}

}
