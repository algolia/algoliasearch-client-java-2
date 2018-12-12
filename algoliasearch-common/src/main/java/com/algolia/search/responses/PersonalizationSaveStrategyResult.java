package com.algolia.search.responses;

import com.algolia.search.custom_serializers.CustomZonedDateTimeDeserializer;
import com.algolia.search.custom_serializers.CustomZonedDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.ZonedDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonalizationSaveStrategyResult {

  public ZonedDateTime getUpdatedAt() {
    return updatedAt;
  }

  public PersonalizationSaveStrategyResult setUpdatedAt(ZonedDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  @JsonSerialize(using = CustomZonedDateTimeSerializer.class)
  @JsonDeserialize(using = CustomZonedDateTimeDeserializer.class)
  private ZonedDateTime updatedAt;
}
