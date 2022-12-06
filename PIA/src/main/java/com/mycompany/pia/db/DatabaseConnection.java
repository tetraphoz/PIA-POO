package com.mycompany.pia.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private Connection connection = null;
    
    public DatabaseConnection() throws IOException, SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pia", "root", "root");
    }
    
    public Connection getConnection() {
        return connection;
    }
}
