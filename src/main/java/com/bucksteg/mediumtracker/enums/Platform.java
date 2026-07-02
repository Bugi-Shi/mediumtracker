package com.bucksteg.mediumtracker.enums;

public enum Platform {
    PC("PC"),
    PS4("PlayStation 4"),
    PS5("PlayStation 5"),
    XBOX("XBOX"),
    NINTENDO_SWITCH("Nintendo Switch"),
    NINTENDO_3DS("Nintendo 3DS"),
    NINTENDO_NDS("Nintendo DS"),
    NINTENDO_GBA("GameBoy Advance"),
    NINTENDO_GBC("GameBoy Color");

    private final String displayName;

    Platform(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
