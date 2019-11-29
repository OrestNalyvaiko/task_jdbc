package com.nalyvaiko.entity;

import java.util.Collection;
import java.util.Objects;

public class AuthorEntity {

  private Integer id;
  private String lastName;
  private String middleName;
  private String firstName;
  private Collection<BookEntity> books;

  public AuthorEntity() {
  }

  public AuthorEntity(String lastName, String middleName,
      String firstName) {
    this.lastName = lastName;
    this.middleName = middleName;
    this.firstName = firstName;
  }

  public AuthorEntity(Integer id, String lastName, String middleName,
      String firstName) {
    this.id = id;
    this.lastName = lastName;
    this.middleName = middleName;
    this.firstName = firstName;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Collection<BookEntity> getBooks() {
    return books;
  }

  public void setBooks(Collection<BookEntity> books) {
    this.books = books;
  }

  @Override
  public String toString() {
    if (!Objects.isNull(middleName)) {
      return
          String.format(" %-5d %-11s %-15s %-20s ", id, firstName, middleName,
              lastName) + books;
    } else {
      return String.format(" %-5d %-11s %-15s ", id, firstName, lastName)
          + books;
    }
  }
}
