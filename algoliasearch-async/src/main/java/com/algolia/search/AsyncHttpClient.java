package com.algolia.search;

import com.algolia.search.exceptions.AlgoliaException;
import com.algolia.search.http.AlgoliaRequest;
import com.algolia.search.http.AsyncAlgoliaHttpClient;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import net.javacrumbs.futureconverter.java8guava.FutureConverter;

import javax.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;

class AsyncHttpClient extends AsyncAlgoliaHttpClient {

  private final ApacheHttpClient internal;
  private final ListeningExecutorService service;

  AsyncHttpClient(AsyncAPIClientConfiguration configuration) {
    this.service = MoreExecutors.listeningDecorator(configuration.getExecutorService());
    this.internal = new ApacheHttpClient(configuration);
  }

  @Override
  public <T> CompletableFuture<T> requestWithRetry(@Nonnull AlgoliaRequest<T> request) {
    return FutureConverter.toCompletableFuture(service.submit(() -> internal.requestWithRetry(request)));
  }

  @Override
  public void close() throws AlgoliaException {
    internal.close();
  }

}
