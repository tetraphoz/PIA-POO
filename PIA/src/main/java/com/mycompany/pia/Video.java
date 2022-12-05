package com.mycompany.pia;

import java.nio.file.Path;

public class Video {
	private int idVideo;
	private String name;
	private String artist;
	private Path videoPath;
	private Path imagePath;
	private boolean favorito;

	public Video(int idVideo, String name, String artist, Path videoPath, Path imagePath) {
		this.idVideo = idVideo;
		this.name = name;
		this.artist = artist;
		this.videoPath = videoPath;
		this.imagePath = imagePath;
	}

	public boolean getFavorito(){
		return favorito;
	}

	public void setFavorito(boolean favorito){
		this.favorito = favorito;
	}

	public int getIdVideo() {
		return idVideo;
	}

	public void setIdVideo(int idVideo) {
		this.idVideo = idVideo;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public Path getVideoPath() {
		return videoPath;
	}
	
	public void setVideoPath(Path videoPath) {
		this.videoPath = videoPath;
	}
	
	public Path getImagePath() {
		return imagePath;
	}
	
	public void setImagePath(Path imagePath) {
		this.imagePath = imagePath;
	}
        
        public Object[] getObjectArray() {
            Object[] oo = {
                idVideo,
                name,
                artist,
                videoPath.toAbsolutePath().toString(),
                imagePath.toAbsolutePath().toString()
            };
            return oo;
        }
}
