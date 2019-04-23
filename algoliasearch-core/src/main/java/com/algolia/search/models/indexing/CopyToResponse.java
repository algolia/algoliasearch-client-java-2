package com.algolia.search.models.indexing;

import java.time.OffsetDateTime;

public class CopyToResponse extends IndexingResponse {

  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public CopyToResponse setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  @Override
  public String toString() {
    return "CopyToResponse{" + "updatedAt=" + updatedAt + '}';
  }

  private OffsetDateTime updatedAt;
}
