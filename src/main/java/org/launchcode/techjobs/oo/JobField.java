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

  // override toString, equals, and hashCode
  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public String toString() {
    return value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
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