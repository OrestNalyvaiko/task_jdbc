package com.nalyvaiko.dao.impl;

import com.nalyvaiko.connection.ConnectionManager;
import com.nalyvaiko.dao.BookCategoryDAO;
import com.nalyvaiko.entity.BookCategoryEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookCategoryDAOImpl implements BookCategoryDAO {

  private static final String GET_ALL = "SELECT * FROM book_category";
  private static final String GET_BY_ID = "SELECT * FROM book_category WHERE id = ?";
  private static final String INSERT = "INSERT INTO book_category (name) VALUES(?)";
  private static final String UPDATE = "UPDATE book_category SET name = ? WHERE id = ?";
  private static final String DELETE = "DELETE FROM book_category WHERE id = ?";

  @Override
  public Collection<BookCategoryEntity> getAll() throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    List<BookCategoryEntity> bookCategoryEntityList = new ArrayList<>();
    try (Statement statement = connection.createStatement()) {
      try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
        while (resultSet.next()) {
          BookCategoryEntity bookCategoryEntity = new BookCategoryEntity();
          bookCategoryEntity.setId(resultSet.getInt("id"));
          bookCategoryEntity.setName(resultSet.getString("name"));

          bookCategoryEntityList.add(bookCategoryEntity);
        }
      }
    }
    return bookCategoryEntityList;
  }

  @Override
  public BookCategoryEntity getById(Integer id) throws SQLException {
    BookCategoryEntity bookCategoryEntity = null;
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection
        .prepareStatement(GET_BY_ID)) {
      preparedStatement.setInt(1, id);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
          bookCategoryEntity = new BookCategoryEntity();

          bookCategoryEntity.setId(resultSet.getInt("id"));
          bookCategoryEntity.setName(resultSet.getString("name"));

        }
      }
    }
    return bookCategoryEntity;
  }

  @Override
  public int insert(BookCategoryEntity entity) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection
        .prepareStatement(INSERT)) {
      preparedStatement.setString(1, entity.getName());

      return preparedStatement.executeUpdate();
    }
  }

  @Override
  public int update(BookCategoryEntity entity) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection
        .prepareStatement(UPDATE)) {
      preparedStatement.setString(1, entity.getName());
      preparedStatement.setInt(2, entity.getId());

      return preparedStatement.executeUpdate();
    }
  }

  @Override
  public int delete(BookCategoryEntity entity) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection
        .prepareStatement(DELETE)) {
      preparedStatement.setInt(1, entity.getId());

      return preparedStatement.executeUpdate();
    }
  }
}
