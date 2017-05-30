package com.algolia.search;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Base class to create AsyncAPIClient
 */
@SuppressWarnings("WeakerAccess")
public abstract class AsyncAPIClientBuilder extends GenericAPIClientBuilder {

  /**
   * Initialize this builder with the applicationId and apiKey
   *
   * @param applicationId APP_ID can be found on https://www.algolia.com/api-keys
   * @param apiKey        Algolia API_KEY can also be found on https://www.algolia.com/api-keys
   */
  public AsyncAPIClientBuilder(@Nonnull String applicationId, @Nonnull String apiKey) {
    super(applicationId, apiKey);
  }

  /**
   * Customize the user agent
   *
   * @param customAgent        key to add to the user agent
   * @param customAgentVersion value of this key to add to the user agent
   * @return this
   */
  @Override
  public AsyncAPIClientBuilder setUserAgent(@Nonnull String customAgent, @Nonnull String customAgentVersion) {
    super.setUserAgent(customAgent, customAgentVersion);
    return this;
  }

  /**
   * Set extra headers to the requests
   *
   * @param key   name of the header
   * @param value value of the header
   * @return this
   */
  @Override
  public AsyncAPIClientBuilder setExtraHeader(@Nonnull String key, String value) {
    super.setExtraHeader(key, value);
    return this;
  }

  /**
   * Set the connect timeout of the HTTP client
   *
   * @param connectTimeout the value in ms
   * @return this
   */
  @Override
  public AsyncAPIClientBuilder setConnectTimeout(int connectTimeout) {
    super.setConnectTimeout(connectTimeout);
    return this;
  }

  /**
   * Set the read timeout of the HTTP client
   *
   * @param readTimeout the value in ms
   * @return this
   */
  @Override
  public AsyncAPIClientBuilder setReadTimeout(int readTimeout) {
    super.setReadTimeout(readTimeout);
    return this;
  }

  /**
   * Set the Jackson ObjectMapper
   *
   * @param objectMapper the mapper
   * @return this
   */
  @Override
  public AsyncAPIClientBuilder setObjectMapper(@Nonnull ObjectMapper objectMapper) {
    super.setObjectMapper(objectMapper);
    return this;
  }

  @Override
  public AsyncAPIClientBuilder setQueryHosts(List<String> queryHosts) {
    super.setQueryHosts(queryHosts);
    return this;
  }

  @Override
  public AsyncAPIClientBuilder setBuildHosts(List<String> buildHosts) {
    super.setBuildHosts(buildHosts);
    return this;
  }

  protected abstract AsyncAPIClient build(@Nonnull AsyncAPIClientConfiguration configuration);

  /**
   * Build an AsyncAPIClient with a default executor of 10 threads
   *
   * @return the built AsyncAPIClient
   */
  public AsyncAPIClient build() {
    return build(Executors.newFixedThreadPool(10));
  }

  /**
   * Build an AsyncAPIClient
   *
   * @param executor the executor to use
   * @return the built AsyncAPIClient
   */
  public AsyncAPIClient build(ExecutorService executor) {
    return build(
      new AsyncAPIClientConfiguration()
        .setExecutor(executor)
        .setApplicationId(applicationId)
        .setApiKey(apiKey)
        .setObjectMapper(objectMapper)
        .setBuildHosts(generateBuildHosts())
        .setQueryHosts(generateQueryHosts())
        .setHeaders(generateHeaders())
        .setConnectTimeout(connectTimeout)
        .setReadTimeout(readTimeout)
    );
  }

}
