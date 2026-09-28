package org.example.museum.resolver;

import org.example.museum.adapter.LegacyPlayerAdapter;
import org.example.museum.legacy.LegacyMuseumPlayer;
import org.example.museum.player.AudioPlayer;

public class LegacyAudioPlayerProvider implements AudioPlayerProvider {

    @Override
    public boolean supports(String mode) {
        return "LEGACY".equalsIgnoreCase(mode);
    }

    @Override
    public AudioPlayer create() {
        return new LegacyPlayerAdapter(new LegacyMuseumPlayer());
    }
}
