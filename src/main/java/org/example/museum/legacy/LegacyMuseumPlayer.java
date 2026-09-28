package org.example.museum.legacy;

public class LegacyMuseumPlayer {

    public static final int SUCCESS = 0;
    public static final int FILE_NOT_FOUND = -1;
    public static final int DEVICE_UNAVAILABLE = -2;
    public static final int UNSUPPORTED_FORMAT = -3;

    public int startLegacyTrack(String filePath, int volumeLevel, long startPosition) {
        if (filePath == null || filePath.isBlank()) {
            return FILE_NOT_FOUND;
        }

        if (!filePath.endsWith(".mp3")) {
            return UNSUPPORTED_FORMAT;
        }

        if (volumeLevel < 0 || volumeLevel > 100) {
            return DEVICE_UNAVAILABLE;
        }

        System.out.println(
                "Legacy player started: " + filePath
                        + ", volume=" + volumeLevel
                        + ", position=" + startPosition
        );

        return SUCCESS;
    }
}
