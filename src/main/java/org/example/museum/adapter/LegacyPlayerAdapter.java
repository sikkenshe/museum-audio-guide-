package org.example.museum.adapter;

import org.example.museum.legacy.LegacyMuseumPlayer;
import org.example.museum.model.AudioTrack;
import org.example.museum.player.AudioPlaybackException;
import org.example.museum.player.AudioPlayer;

public class LegacyPlayerAdapter implements AudioPlayer {

    private final LegacyMuseumPlayer legacyPlayer;

    public LegacyPlayerAdapter(LegacyMuseumPlayer legacyPlayer) {
        this.legacyPlayer = legacyPlayer;
    }

    @Override
    public void play(AudioTrack track) throws AudioPlaybackException {
        if (track == null) {
            throw new AudioPlaybackException("Audio track cannot be null");
        }

        int result = legacyPlayer.startLegacyTrack(
                track.getFilePath(),
                track.getVolume(),
                track.getStartPosition()
        );

        switch (result) {
            case LegacyMuseumPlayer.SUCCESS:
                return;
            case LegacyMuseumPlayer.FILE_NOT_FOUND:
                throw new AudioPlaybackException("Audio file was not found");
            case LegacyMuseumPlayer.DEVICE_UNAVAILABLE:
                throw new AudioPlaybackException("Legacy audio device is unavailable");
            case LegacyMuseumPlayer.UNSUPPORTED_FORMAT:
                throw new AudioPlaybackException("Audio format is not supported by legacy player");
            default:
                throw new AudioPlaybackException("Unknown legacy playback error");
        }
    }
}
