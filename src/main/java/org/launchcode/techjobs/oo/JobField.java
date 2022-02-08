package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {
  protected int id;
  protected static int nextId = 1;
  protected String value;

  public JobField() {
    id = nextId;
    nextId++;
  }

  public JobField(String value){
    this();
    this.value = value;
  }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    JobField jobField = (JobField) o;
    return id == jobField.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return value;
  }

  // getters
  public int getId() {
    return id;
  }

  public String getValue() {
    return value;
  }

  // setter for value
  public void setValue(String value) {
    this.value = value;
  }
}