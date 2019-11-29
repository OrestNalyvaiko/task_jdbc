package com.nalyvaiko.dao;

import com.nalyvaiko.entity.BookEntity;
import java.sql.SQLException;
import java.util.Collection;

public interface BookDAO extends GeneralDAO<BookEntity,Integer> {

  Collection<BookEntity> getBookEntityByAuthor(Integer foreignKey) throws SQLException;
}
