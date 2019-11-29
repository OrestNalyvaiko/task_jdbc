package com.nalyvaiko.services;

import com.nalyvaiko.connection.ConnectionManager;
import com.nalyvaiko.dao.impl.AuthorDAOImpl;
import com.nalyvaiko.dao.impl.BookDAOImpl;
import com.nalyvaiko.entity.AuthorEntity;
import com.nalyvaiko.exception.NoSuchIdException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Objects;

public class AuthorService {

  public Collection<AuthorEntity> getAll() throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    Collection<AuthorEntity> authorEntities = null;
    try {
      connection.setAutoCommit(false);
      authorEntities = new AuthorDAOImpl().getAll();

      for (AuthorEntity authorEntity : authorEntities) {
        authorEntity.setBooks(
            new BookDAOImpl().getBookEntityByAuthor(authorEntity.getId()));
      }
      connection.commit();
      return authorEntities;
    } catch (SQLException e) {
      if (connection != null) {
        System.err.print("Transaction is being rolled back");
        connection.rollback();
      }
    } finally {
      connection.setAutoCommit(true);
    }
    return authorEntities;
  }

  public AuthorEntity getAuthorById(Integer id)
      throws SQLException, NoSuchIdException {
    AuthorEntity authorEntity = new AuthorDAOImpl().getById(id);
    if (Objects.isNull(authorEntity)) {
      throw new NoSuchIdException("Incorrect id");
    }
    return authorEntity;
  }

  public int insertAuthor(AuthorEntity entity) throws SQLException {
    return new AuthorDAOImpl().insert(entity);
  }

  public int updateAuthor(AuthorEntity entity) throws SQLException {
    return new AuthorDAOImpl().update(entity);
  }

  public int deleteAuthor(AuthorEntity entity) throws SQLException {
    return new AuthorDAOImpl().delete(entity);
  }
}

