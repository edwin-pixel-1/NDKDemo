package com.cobos.edwin.demondk

import android.app.ActivityManager
import android.content.Context
import android.opengl.GLSurfaceView
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.cobos.edwin.demondk.gl.GLRenderer
import com.cobos.edwin.jnimodule.NativeModule


class MainActivity : AppCompatActivity() {

    private lateinit var listAdapter: ListAdapter
    private lateinit var listRV: RecyclerView
    private lateinit var glSurfaceView: GLSurfaceView

    private var rendererSet: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initList()
        initButton()
        initGL()
    }

    private fun initGL() {
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val configurationInfo = activityManager.deviceConfigurationInfo
        val supportsEs2 = configurationInfo.reqGlEsVersion >= 0x20000 || Utils.isProbablyEmulator()

        if (supportsEs2) {
            glSurfaceView = findViewById(R.id.glView) //GLSurfaceView(this)

            if (Utils.isProbablyEmulator()) {
                Log.e("ALERT: ", "IS EMULATOR")
                // Avoids crashes on startup with some emulator images.
                glSurfaceView.setEGLConfigChooser(8, 8, 8, 8, 16, 0)
            }

            glSurfaceView.setEGLContextClientVersion(2)
            glSurfaceView.setRenderer(GLRenderer())
            glSurfaceView.renderMode = GLSurfaceView.RENDERMODE_CONTINUOUSLY
            rendererSet = true
        } else {
            Toast.makeText(this, "This device does not support OpenGL ES 2.0.",
                    Toast.LENGTH_LONG).show()
            return
        }
    }


    override fun onPause() {
        super.onPause()
        if(rendererSet)
            glSurfaceView.onPause()
    }

    override fun onResume() {
        super.onResume()
        if(rendererSet)
            glSurfaceView.onResume()
    }

    private fun initList() {
        listRV = findViewById<RecyclerView>(R.id.listView)
        listAdapter = ListAdapter(ArrayList())
        listRV.adapter = listAdapter
        listRV.layoutManager = LinearLayoutManager(this)
    }

    private fun initButton() {
        val button = findViewById<Button>(R.id.addButton)
        button.setOnClickListener {
            val words = NativeModule.getRandomWords()
            listAdapter.addItem(words)
            listRV.scrollToPosition(listAdapter.itemCount - 1)
        }
    }
}
