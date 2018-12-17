package com.cobos.edwin.demondk

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

import com.cobos.edwin.jnimodule.NativeModule

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById<View>(R.id.sample_text) as TextView

        val lib = NativeModule()
        tv.text = lib.randomWord
    }
}
