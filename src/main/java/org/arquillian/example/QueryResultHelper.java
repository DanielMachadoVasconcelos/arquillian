package org.arquillian.example;

public class QueryResultHelper {

	public static QueryResult<String> of(String greeting) {
		return new QueryResult<String>(greeting);
	}
}
