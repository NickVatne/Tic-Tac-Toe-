package no.student.nkv.ultimatetictactoe.screens

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_won.*
import no.student.nkv.ultimatetictactoe.MainActivity
import no.student.nkv.ultimatetictactoe.R

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_won)

        val player = intent.getStringExtra("player")
        if(player == "Tie") textViewWon.text = "TIE"
        else textViewWon.text = "$player WON"

        val anim = AnimationUtils.loadAnimation(applicationContext, R.anim.zoom)
        textViewWon.startAnimation(anim)

        Handler().postDelayed({
            startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
        }, 3000)
    }
}