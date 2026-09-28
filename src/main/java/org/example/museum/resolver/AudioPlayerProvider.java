package org.example.museum.resolver;

import org.example.museum.player.AudioPlayer;

public interface AudioPlayerProvider {
    boolean supports(String mode);
    AudioPlayer create();
}
