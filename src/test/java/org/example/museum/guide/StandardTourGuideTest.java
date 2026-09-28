package org.example.museum.guide;

import org.example.museum.model.AudioTrack;
import org.example.museum.player.AudioPlayer;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class StandardTourGuideTest {

    @Test
    void shouldDelegatePlaybackToAudioPlayer() throws Exception {
        AudioPlayer player = mock(AudioPlayer.class);
        AudioTrack track = new AudioTrack("Test Track", "test.mp3", 50, 0);

        StandardTourGuide guide = new StandardTourGuide(player);
        guide.startTour(track);

        verify(player).play(track);
    }
}
