package com.nalyvaiko.services;

import com.nalyvaiko.dao.impl.BookCategoryDAOImpl;
import com.nalyvaiko.entity.BookCategoryEntity;
import java.sql.SQLException;
import java.util.Collection;

public class BookCategoryService {

  public Collection<BookCategoryEntity> getAll() throws SQLException {
    return new BookCategoryDAOImpl().getAll();
  }

  public BookCategoryEntity getBookCategoryById(Integer id)
      throws SQLException {
    return new BookCategoryDAOImpl().getById(id);
  }

  public int insertBookCategory(BookCategoryEntity entity) throws SQLException {
    return new BookCategoryDAOImpl().insert(entity);
  }

  public int updateBookCategory(BookCategoryEntity entity) throws SQLException {
    return new BookCategoryDAOImpl().update(entity);
  }

  public int deleteBookCategory(BookCategoryEntity entity) throws SQLException {
    return new BookCategoryDAOImpl().delete(entity);
  }
}
