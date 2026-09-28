package org.example.museum.player;

import org.example.museum.model.AudioTrack;

public interface AudioPlayer {
    void play(AudioTrack track) throws AudioPlaybackException;
}
