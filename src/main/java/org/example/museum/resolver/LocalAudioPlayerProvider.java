package org.example.museum.resolver;

import org.example.museum.player.AudioPlayer;
import org.example.museum.player.LocalAudioPlayer;

public class LocalAudioPlayerProvider implements AudioPlayerProvider {

    @Override
    public boolean supports(String mode) {
        return "LOCAL".equalsIgnoreCase(mode);
    }

    @Override
    public AudioPlayer create() {
        return new LocalAudioPlayer();
    }
}
