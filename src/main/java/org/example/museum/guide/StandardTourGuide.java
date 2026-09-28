package org.example.museum.guide;

import org.example.museum.model.AudioTrack;
import org.example.museum.player.AudioPlaybackException;
import org.example.museum.player.AudioPlayer;

public class StandardTourGuide extends AudioGuide {

    public StandardTourGuide(AudioPlayer audioPlayer) {
        super(audioPlayer);
    }

    @Override
    public void startTour(AudioTrack track) throws AudioPlaybackException {
        System.out.println("Starting standard museum tour...");
        audioPlayer.play(track);
    }
}
