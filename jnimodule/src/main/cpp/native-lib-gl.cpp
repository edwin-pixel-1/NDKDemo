//
// Created by Edwin-Cobos on 12/17/2018.
//

#include <jni.h>
#include <string>
#include <android/log.h>
#include <vector>

using namespace std;

vector<string> words = {"tow", "possible", "amuck", "marked", "lonely", "gorgeous", "liquid", "sordid",
                  "vegetable", "ban", "unit", "government", "spiteful", "dear", "person", "typical",
                  "increase", "jolly", "waiting", "addition", "paper", "auspicious", "testy",
                  "ants", "smile", "vigorous", "quarrelsome", "calculate", "faded", "alert",
                  "cheap", "boiling", "expansion", "risk", "unite", "taste", "cherry", "loss",
                  "solid", "disturbed", "sisters", "pumped", "cattle", "overwrought", "belief",
                  "dapper", "governor", "limit", "warlike", "direful", "giraffe", "steam", "cute",
                  "describe", "gamy", "different", "hammer", "profit", "knot", "ordinary", "appear",
                  "discreet", "moaning", "mourn", "lick", "wilderness", "deep", "jagged", "closed",
                  "uppity", "underwear", "faulty", "weary", "stem", "subsequent", "juvenile",
                  "aromatic", "nostalgic", "detail", "ignorant", "clam", "representative", "curvy",
                  "wealth", "whole", "sweltering", "scary", "shoe", "safe", "rest", "decisive",
                  "venomous", "gaze", "greedy", "proud", "load", "grouchy", "dazzling", "well-off",
                  "telling"};

JNIEXPORT jint JNI_OnLoad(JavaVM* vm, void* reserved) {
    JNIEnv* env;
    if (vm->GetEnv(reinterpret_cast<void**>(&env), JNI_VERSION_1_6) != JNI_OK) {
        return -1;
    }

    srand(static_cast<unsigned int>(time(NULL)));

    return JNI_VERSION_1_6;
}

vector<int> getRandomIndex(int quantity, int limit) {
    if(quantity > limit)
        return vector<int>(0);

    vector<int> result(static_cast<unsigned long>(quantity));
    vector<int> mask(static_cast<unsigned long>(limit));
    int count = 0;
    while (count < quantity) {
        int r = rand() % limit;
        if (mask[r] == 0) {
            result[count] = r;
            mask[r] = 1;
            count++;
        }
    }
    return result;
}


extern "C" JNIEXPORT jstring JNICALL
Java_com_cobos_edwin_jnimodule_NativeModule_getRandomWords(JNIEnv *env, jclass) {
    string result = "";
    int randomNumber = rand() % 10 + 1;
    vector<int> indexes = getRandomIndex(randomNumber, static_cast<int>(words.size()));
    for (auto i = indexes.begin(); i != indexes.end(); ++i) {
        result += words[*i] + ", ";
    }

    return env->NewStringUTF(result.c_str());
}

