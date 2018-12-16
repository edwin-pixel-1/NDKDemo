#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_cobos_edwin_jnimodule_NativeModule_getRandomWord(JNIEnv *env, jobject) {
    std::string hello = "Hello from C++ from Module 2";
    return env->NewStringUTF(hello.c_str());
}
