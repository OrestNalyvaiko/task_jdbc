package com.nalyvaiko.dao.impl;

import com.nalyvaiko.connection.ConnectionManager;
import com.nalyvaiko.dao.BookDAO;
import com.nalyvaiko.entity.BookEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookDAOImpl implements BookDAO {

  private static final String GET_BY_PUBLISHER = "SELECT * FROM book WHERE publisher_id = ?";

  @Override
  public Collection<BookEntity> getBookEntityByAuthor(Integer foreignKey)
      throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    List<BookEntity> books = new ArrayList<>();
    try (PreparedStatement preparedStatement = connection
        .prepareStatement(GET_BY_PUBLISHER)) {
      preparedStatement.setInt(1, foreignKey);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
          BookEntity bookEntity = new BookEntity();
          bookEntity.setId(resultSet.getInt("id"));
          bookEntity.setTitle(resultSet.getString("title"));
          bookEntity.setPrice(resultSet.getBigDecimal("price"));
          bookEntity.setPublishingYear(resultSet.getShort("publishing_year"));
          bookEntity.setPublishingCity(resultSet.getString("publishing_city"));
          bookEntity.setCount(resultSet.getInt("count"));

          books.add(bookEntity);
        }
      }
    }
    return books;
  }

  @Override
  public Collection<BookEntity> getAll() throws SQLException {
    return null;
  }

  @Override
  public BookEntity getById(Integer integer) throws SQLException {
    return null;
  }

  @Override
  public int insert(BookEntity entity) throws SQLException {
    return 0;
  }

  @Override
  public int update(BookEntity entity) throws SQLException {
    return 0;
  }

  @Override
  public int delete(BookEntity entity) throws SQLException {
    return 0;
  }
}
