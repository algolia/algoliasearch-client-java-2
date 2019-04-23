package com.algolia.search.models.insights;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InsightsRequest implements Serializable {
  public List<InsightsEvent> getEvents() {
    return events;
  }

  public InsightsRequest setEvents(List<InsightsEvent> events) {
    this.events = events;
    return this;
  }

  @Override
  public String toString() {
    return "InsightsRequest{" + "events=" + events + '}';
  }

  private List<InsightsEvent> events;
}
