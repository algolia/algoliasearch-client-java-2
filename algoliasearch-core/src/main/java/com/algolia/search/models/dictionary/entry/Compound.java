package com.algolia.search.models.dictionary.entry;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/** Represents an entry for Compounds dictionary. */
public class Compound implements DictionaryEntry, Serializable {

  private String objectID;
  private String language;
  private String word;
  private List<String> decomposition;

  // dummy constructor for deserialization
  protected Compound() {}

  public Compound(String objectID, String language, String word, List<String> decomposition) {
    this.objectID = objectID;
    this.language = language;
    this.word = word;
    this.decomposition = decomposition;
  }

  @Override
  public String getObjectID() {
    return objectID;
  }

  public Compound setObjectID(String objectID) {
    this.objectID = objectID;
    return this;
  }

  @Override
  public String getLanguage() {
    return language;
  }

  public Compound setLanguage(String language) {
    this.language = language;
    return this;
  }

  public String getWord() {
    return word;
  }

  public Compound setWord(String word) {
    this.word = word;
    return this;
  }

  public List<String> getDecomposition() {
    return decomposition;
  }

  public Compound setDecomposition(List<String> decomposition) {
    this.decomposition = decomposition;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Compound)) return false;
    Compound compound = (Compound) o;
    return Objects.equals(objectID, compound.objectID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objectID);
  }

  @Override
  public String toString() {
    return "Compound{"
        + "objectID='"
        + objectID
        + '\''
        + ", language='"
        + language
        + '\''
        + ", words='"
        + word
        + '\''
        + ", decomposition="
        + decomposition
        + '}';
  }
}
