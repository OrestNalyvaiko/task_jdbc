package com.nalyvaiko.services;

import com.nalyvaiko.dao.impl.PublisherDAOImpl;
import com.nalyvaiko.entity.PublisherEntity;
import java.sql.SQLException;
import java.util.Collection;

public class PublisherService {


  public Collection<PublisherEntity> getAll() throws SQLException {
    return new PublisherDAOImpl().getAll();
  }

  public PublisherEntity getPublisherById(Integer id) throws SQLException {
    return new PublisherDAOImpl().getById(id);
  }

  public int insertPublisher(PublisherEntity entity) throws SQLException {
    return new PublisherDAOImpl().insert(entity);
  }

  public int updatePublisher(PublisherEntity entity) throws SQLException {
    return new PublisherDAOImpl().update(entity);
  }

  public int deletePublisher(PublisherEntity entity) throws SQLException {
    return new PublisherDAOImpl().delete(entity);
  }
}
