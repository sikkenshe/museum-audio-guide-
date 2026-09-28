package org.example.museum.player;

import org.example.museum.model.AudioTrack;

public class StreamingAudioPlayer implements AudioPlayer {

    @Override
    public void play(AudioTrack track) throws AudioPlaybackException {
        if (track == null) {
            throw new AudioPlaybackException("Audio track cannot be null");
        }

        System.out.println(
                "Streaming audio: " + track.getTitle()
                        + " from " + track.getFilePath()
        );
    }
}
