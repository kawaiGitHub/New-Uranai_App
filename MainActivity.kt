package com.test.myapplication

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var mp:MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv:TextView =findViewById(R.id.tv)
        val btn:Button =findViewById(R.id.btn)

        btn.setOnClickListener {
            val ar = arrayOf("大吉","中吉","小吉","区")

            val ra =Random().nextInt(ar.count())

            tv.text = ar[ra]
        }
        mp = MediaPlayer.create(this,R.raw.bgm)
        mp.isLooping = true
        mp.start()
    }

    override fun onRestart() {
        super.onRestart()
        mp.start()
    }

    override fun onPause() {
        super.onPause()
        mp.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mp.stop()
        mp.release()
    }
}








