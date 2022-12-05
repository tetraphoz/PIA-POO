package com.mycompany.pia.db;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mycompany.pia.Video;
import com.mycompany.pia.VideoBuilder;
import java.nio.file.InvalidPathException;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class VideoManager {

    private Connection conn;
    private PreparedStatement stmnt;
    private ResultSet rs;

    public VideoManager() {
        try {
            this.conn = new DatabaseConnection().getConnection();
        } catch (SQLException | IOException ex) {
            Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean crearVideo(Video v) {
        try {
            stmnt = conn.prepareStatement("INSERT INTO video (name, artist, videoPath, imagePath) VALUES (?,?,?,?)");
            stmnt.setString(1, v.getName());
            stmnt.setString(2, v.getArtist());
            stmnt.setString(3, v.getVideoPath().toAbsolutePath().toString());
            stmnt.setString(4, v.getImagePath().toAbsolutePath().toString());
            stmnt.executeUpdate();
            return true;
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean eliminarVideo(int id) {
        try {
            stmnt = conn.prepareStatement("DELETE FROM video WHERE idvideo = ?");
            stmnt.setInt(1, id);
            stmnt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean actualizarVideo(Video v) {
        try {
            stmnt = conn.prepareStatement("UPDATE video SET name = ?, artist = ?, videoPath = ?, imagePath = ? WHERE (idvideo = ?)");
            stmnt.setString(1, v.getName());
            stmnt.setString(2, v.getArtist());
            stmnt.setString(3, v.getVideoPath().toAbsolutePath().toString());
            stmnt.setString(4, v.getImagePath().toAbsolutePath().toString());
            stmnt.setInt(   5, v.getIdVideo());
            stmnt.executeUpdate();
            return true;
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Video leerVideo(int id) {
        VideoBuilder vb = new VideoBuilder();
        try {
            stmnt = conn.prepareStatement("SELECT * FROM video WHERE idvideo = ?");
            stmnt.setInt(1, id);
            rs = stmnt.executeQuery();

            if (rs.next()) {
                vb.setIdVideo(rs.getInt("idvideo")).setName(rs.getString("name")).setArtist(rs.getString("artist"))
                        .setVideoPath(Paths.get(rs.getString("videoPath")))
                        .setImagePath(Paths.get(rs.getString("imagePath")));
                return vb.build();
            }
        } catch (SQLException | InvalidPathException | NullPointerException ex) {
            Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Video> cargarVideos(){
        VideoBuilder vb = new VideoBuilder();
        List<Video> lista = new ArrayList<>();
        try {
            stmnt = conn.prepareStatement("SELECT * FROM video");
            rs = stmnt.executeQuery();

            while(rs.next()){
//                vb.setIdVideo(rs.getInt("idvideo")).setName(rs.getString("name")).setArtist(rs.getString("artist"))
//                        .setVideoPath(Paths.get(rs.getString("videoPath")))
//                        .setImagePath(Paths.get(rs.getString("imagePath")));
//                lista.add(vb.build());
                
                Video v = new Video(rs.getInt("idvideo"),
                              rs.getString("name"),
                              rs.getString("artist"),
                              Paths.get(rs.getString("videoPath")),
                              Paths.get(rs.getString("imagePath")));
                lista.add(v);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(VideoManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void cargarVideos(DefaultTableModel tm, JComboBox cbxIDVideo) {
        ResultSet rs = null;
        Video v = null;
        try {
            PreparedStatement select = conn.prepareStatement("SELECT * FROM video");
            rs = select.executeQuery();
            
            while(rs.next()) {
                v = new Video(rs.getInt("idvideo"),
                              rs.getString("name"),
                              rs.getString("artist"),
                              Paths.get(rs.getString("videoPath")),
                              Paths.get(rs.getString("imagePath")));
                tm.addRow(v.getObjectArray());
                cbxIDVideo.addItem(rs.getInt("idvideo"));
            }
        } catch(SQLException | NullPointerException ex) {
            Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Video obtenerDatosVideo(int id) {
        Video v = null;
        ResultSet rs = null;
        
        try {
            PreparedStatement select = conn.prepareStatement("SELECT * FROM video WHERE idvideo = ?");
            select.setInt(1, id);
            rs = select.executeQuery();
            
            if(rs.next()) {
                v = new Video(id,
                                    rs.getString("name"),
                                    rs.getString("artist"),
                                    Paths.get(rs.getString("videoPath")),
                                    Paths.get(rs.getString("imagePath")));
            }
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }
}
