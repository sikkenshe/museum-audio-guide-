# Museum Audio Guide System

Assignment 3 project demonstrating **Bridge** and **Adapter** together in one design.

## Patterns

- **Bridge**
  - Abstraction: `AudioGuide`
  - Refined abstractions: `StandardTourGuide`, `InteractiveTourGuide`
  - Implementor: `AudioPlayer`
  - Implementations: `LocalAudioPlayer`, `StreamingAudioPlayer`, `LegacyPlayerAdapter`

- **Adapter**
  - Adaptee: `LegacyMuseumPlayer`
  - Adapter: `LegacyPlayerAdapter`

- **Complexity module**
  - Dynamic implementor selection using `AudioPlayerResolver` and `ServiceLoader`.

## Build and test

```bash
mvn clean test
```

Build runnable JAR:

```bash
mvn clean package
```

Run:

```bash
java -jar target/museum-audio-guide-1.0-SNAPSHOT.jar
```

## Example input

```text
LEGACY
2
```

## Files required by the assignment

- Source code: `src/main/java`
- Unit tests: `src/test/java`
- UML diagram: `docs/uml.svg`
- Design rationale: `docs/design-rationale.md` and `docs/design-rationale.pdf`
