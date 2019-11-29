package com.nalyvaiko.dao;

import java.sql.SQLException;
import java.util.Collection;

public interface GeneralDAO<T, ID> {

  Collection<T> getAll() throws SQLException;

  T getById(ID id) throws SQLException;

  int insert(T entity) throws SQLException;

  int update(T entity) throws SQLException;

  int delete(T entity) throws SQLException;

}
