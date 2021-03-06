package com.algolia.search.recommendation;

import com.algolia.search.DefaultRecommendationClient;
import com.algolia.search.IntegrationTestExtension;
import com.algolia.search.RecommendationClient;
import com.algolia.search.integration.TestHelpers;
import java.io.IOException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({IntegrationTestExtension.class})
class RecommendationTest extends com.algolia.search.integration.recommendation.RecommendationTest {

  private static RecommendationClient recommendationClient =
      DefaultRecommendationClient.create(
          TestHelpers.ALGOLIA_APPLICATION_ID_1, TestHelpers.ALGOLIA_ADMIN_KEY_1, "eu");

  RecommendationTest() {
    super(recommendationClient);
  }

  @AfterAll
  static void close() throws IOException {
    recommendationClient.close();
  }
}
