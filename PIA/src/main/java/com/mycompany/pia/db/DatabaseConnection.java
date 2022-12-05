package com.mycompany.pia.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

  private Connection connection;

  public DatabaseConnection() throws IOException, SQLException {
    // Cargar la configuarcion
    Properties config = new Properties();
    config.load(new FileInputStream("config.properties"));

    // Obtener las propiedades
    String url = config.getProperty("database.url");
    String db_name = config.getProperty("database.name");
    String username = config.getProperty("database.username");
    String password = config.getProperty("database.password");

    // Crear la conexion
    this.connection = DriverManager.getConnection(url+db_name, username, password);
  }

  public Connection getConnection() {
    return this.connection;
  }
}
