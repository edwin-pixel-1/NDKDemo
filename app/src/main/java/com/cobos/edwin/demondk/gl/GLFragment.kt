package com.cobos.edwin.demondk.gl

import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.cobos.edwin.demondk.R


class GLFragment : Fragment() {

    private lateinit var glSurfaceView: CustomGLSurfaceView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        glSurfaceView = CustomGLSurfaceView(this.activity!!)
        return glSurfaceView
    }


    companion object {
    }
}
