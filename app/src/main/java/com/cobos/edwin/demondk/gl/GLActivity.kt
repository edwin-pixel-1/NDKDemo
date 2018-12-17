package com.cobos.edwin.demondk.gl

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.cobos.edwin.demondk.R

class GLActivity : AppCompatActivity() {

    private lateinit var glSurfaceView: CustomGLSurfaceView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initGL()
    }

    private fun initGL() {
        Log.e("Alert", "InitGL")
        glSurfaceView = CustomGLSurfaceView(this)
        setContentView(glSurfaceView)
    }


    override fun onPause() {
        super.onPause()
        if(glSurfaceView.rendererSet)
            glSurfaceView.onPause()
    }

    override fun onResume() {
        super.onResume()
        if(glSurfaceView.rendererSet)
            glSurfaceView.onResume()
    }
}
