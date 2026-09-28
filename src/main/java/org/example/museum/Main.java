package org.example.museum;

import org.example.museum.guide.AudioGuide;
import org.example.museum.guide.InteractiveTourGuide;
import org.example.museum.guide.StandardTourGuide;
import org.example.museum.model.AudioTrack;
import org.example.museum.player.AudioPlaybackException;
import org.example.museum.player.AudioPlayer;
import org.example.museum.resolver.AudioPlayerResolver;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AudioPlayerResolver resolver = new AudioPlayerResolver();

        System.out.println("Choose playback mode:");
        System.out.println("LOCAL");
        System.out.println("STREAMING");
        System.out.println("LEGACY");

        String mode = scanner.nextLine().trim();
        AudioPlayer player = resolver.resolve(mode);

        AudioTrack track = new AudioTrack(
                "Ancient Egypt Exhibition",
                "egypt-tour.mp3",
                70,
                0
        );

        System.out.println("Choose tour type:");
        System.out.println("1 - Standard");
        System.out.println("2 - Interactive");

        String tourType = scanner.nextLine().trim();

        AudioGuide guide = "2".equals(tourType)
                ? new InteractiveTourGuide(player)
                : new StandardTourGuide(player);

        try {
            guide.startTour(track);
        } catch (AudioPlaybackException e) {
            System.out.println("Playback failed: " + e.getMessage());
        }
    }
}
