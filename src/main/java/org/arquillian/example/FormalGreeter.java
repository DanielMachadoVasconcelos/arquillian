package org.arquillian.example;

import java.io.PrintStream;

public class FormalGreeter {

	public void greet(PrintStream to, String name) {
		to.println(createGreeting(name));
	}

	public String createGreeting(String name) {
		return "Nice to meet you Mr. " + name + "!";
	}
	
}
