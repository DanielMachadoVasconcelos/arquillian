package org.arquillian.example;

import java.util.Optional;

import com.google.common.base.MoreObjects;

public class QueryResult<T> {
	
	private T messange;

	QueryResult(T messange) {
		super();
		this.messange = messange;
	}
	
	public Optional<T> get(){
		return Optional.<T>of(this.messange);
	}

	@Override
	public String toString() {
		return MoreObjects
				.toStringHelper( getClass() )
				.omitNullValues()
			    .add( "Mensagens", messange )
			    .toString();
	}
}
