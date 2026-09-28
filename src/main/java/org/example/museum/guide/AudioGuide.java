package org.example.museum.guide;

import org.example.museum.model.AudioTrack;
import org.example.museum.player.AudioPlaybackException;
import org.example.museum.player.AudioPlayer;

public abstract class AudioGuide {

    protected final AudioPlayer audioPlayer;

    protected AudioGuide(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    public abstract void startTour(AudioTrack track) throws AudioPlaybackException;
}
