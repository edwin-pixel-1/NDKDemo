//
// Created by Edwin-Cobos on 12/17/2018.
//

#include <jni.h>
#include <string>
#include <android/log.h>
#include <GLES2/gl2.h>
#include <GLES2/gl2ext.h>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

void renderFrame();

void setupGL(jint w, jint h);

GLuint vertexbuffer;
const GLfloat gTriangleVertices[] = { 0.0f, 0.5f, -0.5f, -0.5f,
                                      0.5f, -0.5f };

JNIEXPORT jint JNI_OnLoad(JavaVM* vm, void* reserved) {
    JNIEnv* env;
    if (vm->GetEnv(reinterpret_cast<void**>(&env), JNI_VERSION_1_6) != JNI_OK) {
        return -1;
    }
    return JNI_VERSION_1_6;
}


extern "C" JNIEXPORT void JNICALL
Java_com_cobos_edwin_jnimodule_NativeGL_init(JNIEnv *env, jclass clazz, jint w, jint h) {
    setupGL(w, h);
}

extern "C" JNIEXPORT void JNICALL
Java_com_cobos_edwin_jnimodule_NativeGL_update(JNIEnv *env, jclass clazz) {
    renderFrame();
}

void setupGL(jint w, jint h) {
    glViewport(0, 0, w, h);
}

void renderFrame() {
    static float grey = 0.5f;
    glClearColor(grey, grey, grey, 1.0f);
    glClear( GL_DEPTH_BUFFER_BIT | GL_COLOR_BUFFER_BIT);


    glEnableVertexAttribArray(0);
    glBindBuffer(GL_ARRAY_BUFFER, vertexbuffer);
    glVertexAttribPointer(
            0,               
            3,
            GL_FLOAT,
            GL_FALSE,
            0,
            gTriangleVertices
    );

    glDrawArrays(GL_TRIANGLES, 0, 3); // Starting from vertex 0; 3 vertices total -> 1 triangle
    glDisableVertexAttribArray(0);
}