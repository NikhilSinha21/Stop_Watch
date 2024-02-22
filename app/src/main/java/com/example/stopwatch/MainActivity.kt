package com.example.stopwatch

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log.v
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.core.view.isInvisible
import com.example.stopwatch.R.color.lapWhenStartButtonOn
import com.example.stopwatch.R.color.resume
import com.example.stopwatch.R.color.stop
import java.lang.System.currentTimeMillis
import kotlin.math.min
import java.lang.System.nanoTime as systemNanoTime


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    var button = false
    var button3 = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // this.requestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        //this code is on controlling three dot(navigation) button
        val chrono = findViewById<Chronometer>(R.id.timer)

        val threeDot = findViewById<ImageButton>(R.id.threedot)
        val dotCard = findViewById<CardView>(R.id.dotcard)
        threeDot.setOnClickListener {
            dotCard.isInvisible = false
        }
        dotCard.setOnClickListener {
            dotCard.isInvisible = true
        }

    }

    //this fun is made for controlling background
    fun backGround(view: View) {
        val dotCard = findViewById<CardView>(R.id.dotcard)
        dotCard.isInvisible = true
    }

    @SuppressLint("ResourceAsColor", "SetTextI18n")
    fun button1(view: View) {
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val chrono = findViewById<Chronometer>(R.id.timer)

       if(button == false){
           chrono.start()
        button = true
           button1.text="stop"
           button1.background(stop)
           button2.text = "Lap"
       }else{
           chrono.stop()
           button = false
           button3 = true
           button1.text="Resume"
           button2.text = "Reset"
       }

    }

    @SuppressLint("SetTextI18n")
    fun button2(view: View) {

            if(button3== true) {
                val button2 = findViewById<Button>(R.id.button2)
                val chrono = findViewById<Chronometer>(R.id.timer)
                chrono.base = SystemClock.elapsedRealtime()

            }

    }

}

