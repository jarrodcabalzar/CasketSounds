package com.casketsounds;

public enum Sound {
    CASKET("clueCasket.wav");

    private final String fileName;

    Sound(String fileName) {
        this.fileName = fileName;
    }

    String getFileName() {
        return fileName;
    }

    public static final Sound[] CASKET_SOUNDS = new Sound[]{
            Sound.CASKET
    };
}
