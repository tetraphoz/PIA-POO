package com.mycompany.pia;

import java.nio.file.Path;

public class Video {
	private int idVideo;
	private String name;
	private String artist;
	private Path videoPath;
	private Path imagePath;
        private boolean isFavorite;

	public Video(int idVideo, String name, String artist, Path videoPath, Path imagePath, boolean isFavorite) {
		this.idVideo = idVideo;
		this.name = name;
		this.artist = artist;
		this.videoPath = videoPath;
		this.imagePath = imagePath;
                this.isFavorite = isFavorite;
	}
        
        public boolean getIsFavorite() {
            return isFavorite;
        }
        
        public void setIsFavorite(boolean isFavorite) {
            this.isFavorite = isFavorite;
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
                imagePath.toAbsolutePath().toString(),
                isFavorite
            };
            return oo;
        }
}
