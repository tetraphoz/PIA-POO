package com.mycompany.pia.db;

import com.mycompany.pia.Usuario;
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
        } catch (IOException | SQLException ex) {
            Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearUsuario(Usuario u) {
        try {
            stmnt = conn.prepareStatement("INSERT INTO user (email, username, password) VALUES (?,?,?)");
            stmnt.setString(1, u.getEmail());
            stmnt.setString(2, u.getUsername());
            stmnt.setString(3, u.getPassword());
            stmnt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean usuarioValido(Usuario u) {
        try {
            stmnt = conn.prepareStatement("SELECT * FROM user WHERE email = ? and password = ?");
            stmnt.setString(1, u.getEmail());
            stmnt.setString(2, u.getPassword());
            rs = stmnt.executeQuery();

            // Si rs.next() avanza existe un usuario valido
            // y regresa true; false en caso contrario
            if(rs.next()) {
                u.setUsername(rs.getString("username"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // En caso de algun fallo
        return false;
    }
    
    public boolean checkUserExistance(Usuario u) {
        try {
            stmnt = conn.prepareStatement("SELECT * FROM user WHERE email = ?");
            stmnt.setString(1, u.getEmail());
            rs = stmnt.executeQuery();
            
            // Si rs.next() avanza existe un usuario valido
            // y regresa true; false en caso contrario
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // En caso de algun fallo, regresar true para evitar
        // el registro duplicado de usuarios
        return true;
    }
}
