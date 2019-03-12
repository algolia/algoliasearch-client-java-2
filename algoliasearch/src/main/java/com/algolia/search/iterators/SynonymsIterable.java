package com.algolia.search.iterators;

import com.algolia.search.clients.SearchIndex;
import com.algolia.search.models.Synonym;
import com.algolia.search.objects.RequestOptions;
import java.util.Iterator;
import java.util.Objects;
import javax.annotation.Nonnull;

@SuppressWarnings("WeakerAccess")
public class SynonymsIterable implements Iterable<Synonym> {

  private final SearchIndex<?> index;
  private final Integer hitsPerPage;
  private final RequestOptions requestOptions;

  public SynonymsIterable(@Nonnull SearchIndex<?> index) {
    this(index, 1000, null);
  }

  public SynonymsIterable(@Nonnull SearchIndex<?> index, @Nonnull Integer hitsPerPage) {
    this(index, hitsPerPage, null);
  }

  public SynonymsIterable(
      @Nonnull SearchIndex<?> index, @Nonnull Integer hitsPerPage, RequestOptions requestOptions) {

    Objects.requireNonNull(index, "Index is required");
    Objects.requireNonNull(hitsPerPage, "hitsPerPage is required");

    this.index = index;
    this.hitsPerPage = hitsPerPage;
    this.requestOptions = requestOptions;
  }

  @Override
  @Nonnull
  public Iterator<Synonym> iterator() {
    return new SynonymsIterator(index, hitsPerPage, requestOptions);
  }
}