package com.cobos.edwin.demondk.gl

import android.app.ActivityManager
import android.content.Context
import android.opengl.GLSurfaceView
import android.util.AttributeSet
import android.util.Log
import com.cobos.edwin.demondk.Utils
import android.util.DisplayMetrics



class CustomGLSurfaceView : GLSurfaceView {

    var rendererSet: Boolean = false

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }



    private fun init(context: Context) {
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val configurationInfo = activityManager.deviceConfigurationInfo
        val supportsEs2 = configurationInfo.reqGlEsVersion >= 0x20000 || Utils.isProbablyEmulator()


        Log.e("DEMO ALERT: ", "check "+supportsEs2)
        if (supportsEs2) {

            if (Utils.isProbablyEmulator()) {
                Log.e("DEMO ALERT: ", "IS EMULATOR")
                // Avoids crashes on startup with some emulator images.
                setEGLConfigChooser(8, 8, 8, 8, 16, 0)
            }

            setEGLContextClientVersion(2)
            setRenderer(GLRenderer())
            renderMode = GLSurfaceView.RENDERMODE_CONTINUOUSLY
            rendererSet = true
        }
    }
}
