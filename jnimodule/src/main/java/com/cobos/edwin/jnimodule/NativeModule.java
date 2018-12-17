package com.cobos.edwin.jnimodule;

public class NativeModule {
    static {
        System.loadLibrary("native-lib-gl");
    }

    public static native String getRandomWords();
}
