package com.mycompany.pia;

import java.nio.file.Path;

public class Video {
	private String name;
	private String artist;
	private Path videoPath;
	private Path imagePath;

	public Video(String name, String artist, Path videoPath, Path imagePath){
		this.name = name;
		this.artist = artist;
		this.videoPath = videoPath;
		this.imagePath = imagePath;
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
}
