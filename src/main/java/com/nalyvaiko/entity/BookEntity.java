package com.nalyvaiko.entity;

import java.math.BigDecimal;

public class BookEntity {

  private Integer id;
  private String title;
  private BigDecimal price;
  private BookCategoryEntity bookCategoryId;
  private Integer publisherId;
  private Short publishingYear;
  private String publishingCity;
  private Integer count;

  public BookEntity() {
  }


  public BookEntity(Integer id, String title, BigDecimal price,
      BookCategoryEntity bookCategoryId, Integer publisherId,
      Short publishingYear, String publishingCity, Integer count) {
    this.id = id;
    this.title = title;
    this.price = price;
    this.bookCategoryId = bookCategoryId;
    this.publisherId = publisherId;
    this.publishingYear = publishingYear;
    this.publishingCity = publishingCity;
    this.count = count;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public BookCategoryEntity getBookCategoryId() {
    return bookCategoryId;
  }

  public void setBookCategoryId(BookCategoryEntity bookCategoryId) {
    this.bookCategoryId = bookCategoryId;
  }

  public Integer getPublisherId() {
    return publisherId;
  }

  public void setPublisherId(Integer publisherId) {
    this.publisherId = publisherId;
  }

  public Short getPublishingYear() {
    return publishingYear;
  }

  public void setPublishingYear(Short publishingYear) {
    this.publishingYear = publishingYear;
  }

  public String getPublishingCity() {
    return publishingCity;
  }

  public void setPublishingCity(String publishingCity) {
    this.publishingCity = publishingCity;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }


  @Override
  public String toString() {
    return String
        .format(" %-5d %-11s %-15f %-20d %-23s %-27d", id, title, price,
            publishingYear, publishingCity, count);
  }
}
