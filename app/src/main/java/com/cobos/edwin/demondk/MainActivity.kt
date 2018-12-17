package com.cobos.edwin.demondk

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import com.cobos.edwin.demondk.gl.GLActivity
import com.cobos.edwin.jnimodule.NativeModule


class MainActivity : AppCompatActivity() {

    private lateinit var listAdapter: ListAdapter
    private lateinit var listRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initList()
        initButtons()
    }



    private fun initList() {
        listRV = findViewById<RecyclerView>(R.id.listView)
        listAdapter = ListAdapter(ArrayList())
        listRV.adapter = listAdapter
        listRV.layoutManager = LinearLayoutManager(this)
    }

    private fun initButtons() {
        val button1 = findViewById<Button>(R.id.addButton)
        button1.setOnClickListener {
            val words = NativeModule.getRandomWords()
            listAdapter.addItem(words)
            listRV.scrollToPosition(listAdapter.itemCount - 1)
        }

        val button2 = findViewById<Button>(R.id.openGL)
        button2.setOnClickListener {
            val i = Intent(this, GLActivity::class.java)
            startActivity(i)
        }
    }
}
