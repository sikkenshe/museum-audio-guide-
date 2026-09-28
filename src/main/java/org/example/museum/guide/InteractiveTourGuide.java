package org.example.museum.guide;

import org.example.museum.model.AudioTrack;
import org.example.museum.player.AudioPlaybackException;
import org.example.museum.player.AudioPlayer;

public class InteractiveTourGuide extends AudioGuide {

    public InteractiveTourGuide(AudioPlayer audioPlayer) {
        super(audioPlayer);
    }

    @Override
    public void startTour(AudioTrack track) throws AudioPlaybackException {
        System.out.println("Starting interactive museum tour...");
        System.out.println("Interactive mode: extra visitor prompts enabled.");
        audioPlayer.play(track);
    }
}
