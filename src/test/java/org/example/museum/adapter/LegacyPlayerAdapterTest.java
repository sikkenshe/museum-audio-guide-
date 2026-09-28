package org.example.museum.adapter;

import org.example.museum.legacy.LegacyMuseumPlayer;
import org.example.museum.model.AudioTrack;
import org.example.museum.player.AudioPlaybackException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LegacyPlayerAdapterTest {

    @Test
    void shouldTranslateLegacyFailureIntoAudioPlaybackException() {
        LegacyMuseumPlayer legacyPlayer = mock(LegacyMuseumPlayer.class);

        when(legacyPlayer.startLegacyTrack("missing.mp3", 50, 0))
                .thenReturn(LegacyMuseumPlayer.FILE_NOT_FOUND);

        LegacyPlayerAdapter adapter = new LegacyPlayerAdapter(legacyPlayer);
        AudioTrack track = new AudioTrack("Missing", "missing.mp3", 50, 0);

        AudioPlaybackException exception = assertThrows(
                AudioPlaybackException.class,
                () -> adapter.play(track)
        );

        assertEquals("Audio file was not found", exception.getMessage());
    }
}
