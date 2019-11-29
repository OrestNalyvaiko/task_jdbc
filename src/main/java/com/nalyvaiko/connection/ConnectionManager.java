package com.nalyvaiko.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class ConnectionManager {

  private static Connection connection;
  private static final String URL = "jdbc:mysql://localhost:3306/book_catalog?serverTimezone=UTC&useSSL=false";
  private static final String USER = "root";
  private static final String PASSWORD = "password";

  private ConnectionManager() {
  }

  public static Connection getConnection() {
    if (Objects.isNull(connection)) {
      try {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
      } catch (SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
      }
    }
    return connection;
  }
}
