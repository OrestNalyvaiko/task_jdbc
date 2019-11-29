package com.nalyvaiko.entity;

public class PublisherEntity {

  private Integer id;
  private String name;

  public PublisherEntity() {
  }

  public PublisherEntity(Integer id, String name) {
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
    return String.format(" %-5d %-11s ", id, name);
  }
}
