package org.example.museum.model;

public class AudioTrack {

    private final String title;
    private final String filePath;
    private final int volume;
    private final long startPosition;

    public AudioTrack(String title, String filePath, int volume, long startPosition) {
        this.title = title;
        this.filePath = filePath;
        this.volume = volume;
        this.startPosition = startPosition;
    }

    public String getTitle() {
        return title;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getVolume() {
        return volume;
    }

    public long getStartPosition() {
        return startPosition;
    }
}
