package com.cobos.edwin.demondk.gl;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;

import com.cobos.edwin.jnimodule.NativeGL;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GLRenderer implements GLSurfaceView.Renderer {
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
        NativeGL.init(width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        NativeGL.update();
    }
}
