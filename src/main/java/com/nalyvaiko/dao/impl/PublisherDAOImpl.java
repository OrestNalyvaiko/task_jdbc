package com.nalyvaiko.dao.impl;

import com.nalyvaiko.connection.ConnectionManager;
import com.nalyvaiko.dao.PublisherDAO;
import com.nalyvaiko.entity.PublisherEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PublisherDAOImpl implements PublisherDAO {

  private static final String GET_ALL = "SELECT * FROM publisher";
  private static final String GET_BY_ID = "SELECT * FROM publisher WHERE id = ?";
  private static final String INSERT = "INSERT INTO publisher (name) VALUES (?)";
  private static final String UPDATE = "UPDATE publisher SET name = ? WHERE id = ?";
  private static final String DELETE = "DELETE FROM publisher WHERE id = ?";


  @Override
  public Collection<PublisherEntity> getAll() throws SQLException {
    List<PublisherEntity> publishers = new ArrayList<>();
    Connection connection = ConnectionManager.getConnection();
    try (Statement statement = connection.createStatement()) {
      try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
        while (resultSet.next()) {
          PublisherEntity publisherEntity = new PublisherEntity();
          publisherEntity.setId(resultSet.getInt("id"));
          publisherEntity.setName(resultSet.getString("name"));

          publishers.add(publisherEntity);
        }
      }
    }
    return publishers;
  }

  @Override
  public PublisherEntity getById(Integer id) throws SQLException {
    PublisherEntity publisherEntity = null;
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection
        .prepareStatement(GET_BY_ID)) {
      preparedStatement.setInt(1, id);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
          publisherEntity = new PublisherEntity();

          publisherEntity.setId(resultSet.getInt("id"));
          publisherEntity.setName(resultSet.getString("name"));
        }
      }
    }
    return publisherEntity;
  }

  @Override
  public int insert(PublisherEntity entity) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection
        .prepareStatement(INSERT)) {
      preparedStatement.setString(1, entity.getName());
      return preparedStatement.executeUpdate();
    }
  }

  @Override
  public int update(PublisherEntity entity) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection
        .prepareStatement(UPDATE)) {
      preparedStatement.setString(1, entity.getName());
      preparedStatement.setInt(2, entity.getId());

      return preparedStatement.executeUpdate();
    }
  }

  @Override
  public int delete(PublisherEntity entity) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection
        .prepareStatement(DELETE)) {
      preparedStatement.setInt(1, entity.getId());

      return preparedStatement.executeUpdate();
    }
  }
}
