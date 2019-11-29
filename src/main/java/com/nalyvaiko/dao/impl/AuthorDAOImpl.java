package com.nalyvaiko.dao.impl;

import com.nalyvaiko.connection.ConnectionManager;
import com.nalyvaiko.dao.AuthorDAO;
import com.nalyvaiko.entity.AuthorEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AuthorDAOImpl implements AuthorDAO {

  private static final String GET_ALL = "SELECT * FROM author";
  private static final String GET_BY_ID = "SELECT * FROM author WHERE id = ?";
  private static final String INSERT = "INSERT INTO author (last_name,middle_name,first_name) VALUES (?,?,?)";
  private static final String UPDATE = "UPDATE author SET last_name = ?, middle_name = ?, first_name = ? WHERE id = ?";
  private static final String DELETE = "DELETE FROM author WHERE id = ?";

  @Override
  public Collection<AuthorEntity> getAll() throws SQLException {
    List<AuthorEntity> authors = new ArrayList<>();
    Connection connection = ConnectionManager.getConnection();
    try (Statement statement = connection.createStatement()) {
      try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
        while (resultSet.next()) {
          AuthorEntity authorEntity = new AuthorEntity();
          authorEntity.setId(resultSet.getInt("id"));
          authorEntity.setLastName(resultSet.getString("last_name"));
          authorEntity.setMiddleName(resultSet.getString("middle_name"));
          authorEntity.setFirstName(resultSet.getString("first_name"));

          authors.add(authorEntity);
        }
      }
    }
    return authors;
  }

  @Override
  public AuthorEntity getById(Integer id) throws SQLException {
    AuthorEntity authorEntity = null;
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection
        .prepareStatement(GET_BY_ID)) {
      preparedStatement.setInt(1, id);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
          authorEntity = new AuthorEntity();

          authorEntity.setId(resultSet.getInt("id"));
          authorEntity.setLastName(resultSet.getString("last_name"));
          authorEntity.setMiddleName(resultSet.getString("middle_name"));
          authorEntity.setFirstName(resultSet.getString("first_name"));
        }
      }
    }
    return authorEntity;
  }

  @Override
  public int insert(AuthorEntity entity) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection
        .prepareStatement(INSERT)) {
      preparedStatement.setString(1, entity.getLastName());
      preparedStatement.setString(2, entity.getMiddleName());
      preparedStatement.setString(3, entity.getFirstName());

      return preparedStatement.executeUpdate();
    }
  }

  @Override
  public int update(AuthorEntity entity) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection
        .prepareStatement(UPDATE)) {
      preparedStatement.setString(1, entity.getLastName());
      preparedStatement.setString(2, entity.getMiddleName());
      preparedStatement.setString(3, entity.getFirstName());
      preparedStatement.setInt(4, entity.getId());

      return preparedStatement.executeUpdate();
    }
  }

  @Override
  public int delete(AuthorEntity entity) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection
        .prepareStatement(DELETE)) {
      preparedStatement.setInt(1, entity.getId());

      return preparedStatement.executeUpdate();
    }
  }


}
