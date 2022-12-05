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

public class VideoManager {

    private Connection conn;
    private PreparedStatement stmnt;
    private ResultSet rs;

    public VideoManager() {
        try {
            this.conn = new DatabaseConnection().getConnection();
        } catch (IOException ex) {
            Logger.getLogger(VideoManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VideoManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearVideo(Video v) {
        try {
            stmnt = conn.prepareStatement("INSERT INTO user (name, artist, videoPath, imagePath) VALUES (?,?,?,?)");
            stmnt.setString(1, v.getName());
            stmnt.setString(2, v.getArtist());
            stmnt.setString(3, v.getVideoPath().toAbsolutePath().toString());
            stmnt.setString(4, v.getImagePath().toAbsolutePath().toString());
            stmnt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VideoManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarVideo(int id) {
        try {
            stmnt = conn.prepareStatement("DELETE FROM video WHERE idvideo = ?");
            stmnt.setInt(1, id);
            stmnt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VideoManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarVideo(Video v) {
        try {
            stmnt = conn.prepareStatement("UPDATE user SET name = ?, artist = ?, videoPath = ?, imagePath = ? WHERE idvideo = ?");
            stmnt.setString(1, v.getName());
            stmnt.setString(2, v.getArtist());
            stmnt.setString(3, v.getVideoPath().toAbsolutePath().toString());
            stmnt.setString(4, v.getImagePath().toAbsolutePath().toString());
            stmnt.setInt(   5, v.getIdVideo());
            stmnt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VideoManager.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(VideoManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Video> leerCatalogo(){
        VideoBuilder vb = new VideoBuilder();
        var lista = new ArrayList<Video>();
        try {
            stmnt = conn.prepareStatement("SELECT * FROM video");
            rs = stmnt.executeQuery();

            while(rs.next()){
                vb.setIdVideo(rs.getInt("idvideo")).setName(rs.getString("name")).setArtist(rs.getString("artist"))
                        .setVideoPath(Paths.get(rs.getString("videoPath")))
                        .setImagePath(Paths.get(rs.getString("imagePath")));
                lista.add(vb.build());
            }
        } catch (SQLException ex) {
            Logger.getLogger(VideoManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
