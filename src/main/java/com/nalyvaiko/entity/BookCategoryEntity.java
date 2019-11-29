package com.nalyvaiko.entity;

public class BookCategoryEntity {

  private Integer id;
  private String name;

  public BookCategoryEntity() {
  }

  public BookCategoryEntity(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return String.format(" %-11d %-15s ", id, name);
  }
}
