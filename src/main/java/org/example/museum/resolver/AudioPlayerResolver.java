package org.example.museum.resolver;

import org.example.museum.player.AudioPlayer;

import java.util.List;
import java.util.ServiceLoader;

public class AudioPlayerResolver {

    private final List<AudioPlayerProvider> providers;

    public AudioPlayerResolver() {
        this(ServiceLoader.load(AudioPlayerProvider.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .toList());
    }

    public AudioPlayerResolver(List<AudioPlayerProvider> providers) {
        this.providers = List.copyOf(providers);
    }

    public AudioPlayer resolve(String mode) {
        return providers.stream()
                .filter(provider -> provider.supports(mode))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Unsupported playback mode: " + mode)
                )
                .create();
    }
}
