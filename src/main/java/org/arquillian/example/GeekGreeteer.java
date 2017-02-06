package org.arquillian.example;

import java.io.PrintStream;

public class GeekGreeteer {

	public void greet(PrintStream to, String name) {
		to.println(createGreeting(name));
	}

	public String createGreeting(String name) {
		return "Be the 'Force' with you, " + name + "!";
	}
	
	public String createDroidGreeting(String name) {
		return new StringBuffer()
				.append("Bip Bip Bip ")
				.append(name)
				.append("!")
				.toString();
	}
}
