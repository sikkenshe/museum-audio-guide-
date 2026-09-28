package org.example.museum.guide;

import org.example.museum.model.AudioTrack;
import org.example.museum.player.AudioPlayer;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class InteractiveTourGuideTest {

    @Test
    void shouldDelegatePlaybackToAudioPlayer() throws Exception {
        AudioPlayer player = mock(AudioPlayer.class);
        AudioTrack track = new AudioTrack("Interactive Track", "interactive.mp3", 60, 0);

        InteractiveTourGuide guide = new InteractiveTourGuide(player);
        guide.startTour(track);

        verify(player).play(track);
    }
}
