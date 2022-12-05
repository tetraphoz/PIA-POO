package com.mycompany.pia;

import java.nio.file.Path;

public class VideoBuilder {
    private int idVideo;
    private String name;
    private String artist;
    private Path videoPath;
    private Path imagePath;
    private boolean isFavorite;

    public VideoBuilder setIdVideo(int idVideo) {
        this.idVideo = idVideo;
        return this;
    }

    public VideoBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public VideoBuilder setArtist(String artist) {
        this.artist = artist;
        return this;
    }

    public VideoBuilder setVideoPath(Path videoPath) {
        this.videoPath = videoPath;
        return this;
    }

    public VideoBuilder setImagePath(Path imagePath) {
        this.imagePath = imagePath;
        return this;
    }
    
    public VideoBuilder setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
        return this;
    }

    public Video build() {
        return new Video(idVideo, name, artist, videoPath, imagePath, isFavorite);
    }
}
