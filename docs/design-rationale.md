# Design Rationale — Museum Audio Guide System

## Problem

The system models a museum audio guide. A museum can provide different tour behaviors while using different playback technologies. The two dimensions should be able to change independently.

## Why Bridge

`AudioGuide` is the abstraction and depends only on the `AudioPlayer` implementor interface. `StandardTourGuide` and `InteractiveTourGuide` are refined abstractions. `LocalAudioPlayer`, `StreamingAudioPlayer`, and `LegacyPlayerAdapter` are implementor variants.

Without Bridge, the project could grow into classes such as `StandardLocalGuide`, `StandardStreamingGuide`, `InteractiveLocalGuide`, and so on. Bridge avoids this combination explosion.

## Why Adapter

`LegacyMuseumPlayer` is genuinely incompatible with `AudioPlayer`. The modern interface expects `play(AudioTrack)` and uses `AudioPlaybackException`. The legacy class instead takes separate parameters and returns integer error codes.

`LegacyPlayerAdapter` converts `AudioTrack` to the legacy method parameters and translates all legacy error codes into meaningful `AudioPlaybackException` messages. No legacy-specific constants or failure mechanism leak into the abstraction side.

## Why one pattern alone is not enough

Bridge separates tour behavior from playback technology, but it cannot directly make an incompatible legacy API implement the modern contract.

Adapter solves the compatibility issue, but it does not separate the tour hierarchy from the player hierarchy.

The two patterns therefore solve different parts of the same design.

## Required complexity module

**Dynamic implementor selection** is used.

`AudioPlayerResolver` receives the playback mode at runtime and chooses a matching `AudioPlayerProvider`. Providers are discovered through Java `ServiceLoader`, so the client does not hard-code a concrete player implementation.

## Open/Closed Principle

A new tour type can be added by creating another `AudioGuide` subclass.

A new playback implementation can be added by implementing `AudioPlayer`, creating a provider, and registering that provider as a service. Existing guide classes and the resolver logic do not need to be changed.

## Limitation

The project simulates playback with console output. It does not use real audio files, streaming servers, or museum hardware. Those details could be added later behind the same `AudioPlayer` interface.
