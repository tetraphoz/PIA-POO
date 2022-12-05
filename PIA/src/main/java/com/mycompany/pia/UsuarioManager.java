package com.mycompany.pia;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioManager {

    private Connection conn;
    private PreparedStatement stmnt;
    private ResultSet rs;

    public UsuarioManager() {
        try {
            this.conn = new DatabaseConnection().getConnection();
        } catch (IOException ex) {
            Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearUsuario(Usuario u) {
        try {
            stmnt = conn.prepareStatement("INSERT INTO user (email, username, password) VALUES (?,?,?)");
            stmnt.setString(1, u.email);
            stmnt.setString(2, u.username);
            stmnt.setString(3, u.password);
            stmnt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean UsuarioValido(String email, String password) {
        try {
            stmnt = conn.prepareStatement("SELECT * FROM user WHERE email = ? and password = ?");
            stmnt.setString(1, email);
            stmnt.setString(2, password);
            rs = stmnt.executeQuery();

            // Si rs.next() avanza existe un usuario valido
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        // En caso de algun fallo
        return false;
    }
}
