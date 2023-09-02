package com.casketsounds;

public enum Sound {
    CASKET("casket.wav"),
    CASKET2("casket2.wav");

    private final String fileName;

    Sound(String fileName) {
        this.fileName = fileName;
    }

    String getFileName() {
        return fileName;
    }

    public static final Sound[] CASKET_SOUNDS = new Sound[]{
            Sound.CASKET,
            Sound.CASKET2
    };
}
