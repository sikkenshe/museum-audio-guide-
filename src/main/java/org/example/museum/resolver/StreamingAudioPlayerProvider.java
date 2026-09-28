package org.example.museum.resolver;

import org.example.museum.player.AudioPlayer;
import org.example.museum.player.StreamingAudioPlayer;

public class StreamingAudioPlayerProvider implements AudioPlayerProvider {

    @Override
    public boolean supports(String mode) {
        return "STREAMING".equalsIgnoreCase(mode);
    }

    @Override
    public AudioPlayer create() {
        return new StreamingAudioPlayer();
    }
}
