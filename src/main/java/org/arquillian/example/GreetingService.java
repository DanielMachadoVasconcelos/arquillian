package org.arquillian.example;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public class GreetingService {

	@Inject
	private Greeter greeting;
	
	@Inject
	private GeekGreeteer geekGreeting;
	
	@Inject
	private FormalGreeter formalGreeting;

	public void execute() {
		
		ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
		
		List<ListenableFuture<QueryResult<String>>> queries = Arrays.asList(service.submit(new Callable<QueryResult<String>>() {
			public QueryResult<String> call() {
				return QueryResultHelper.of(greeting.createGreeting("Daniel"));
			}
		}), service.submit(new Callable<QueryResult<String>>() {
			public QueryResult<String> call() {
				return QueryResultHelper.of(geekGreeting.createDroidGreeting("Paulo"));
			}
		}), service.submit(new Callable<QueryResult<String>>() {
			public QueryResult<String> call() {
				return QueryResultHelper.of(formalGreeting.createGreeting("Antonio"));
			}
		}), service.submit(new Callable<QueryResult<String>>() {
			public QueryResult<String> call() {
				return QueryResultHelper.of(geekGreeting.createGreeting("Obi Wan"));
			}
		}));

		ListenableFuture<List<QueryResult<String>>> successfulQueries = Futures.successfulAsList(queries);

		Futures.addCallback(successfulQueries, new FutureCallback<List<QueryResult<String>>>() {
			public void onSuccess(List<QueryResult<String>> result) {
				System.out.println(result);
			}

			public void onFailure(Throwable thrown) {
				System.out.println(thrown);
			}
		});
		
		MoreExecutors
			.shutdownAndAwaitTermination(service, 5 , TimeUnit.SECONDS);
	}
}
