package no.student.nkv.ultimatetictactoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.Window
import android.view.WindowManager
import no.student.nkv.ultimatetictactoe.screens.MenuFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
       setContentView(R.layout.activity_main)
        showMenu()
    }
    fun replaceFragment(containerID: Int, fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(containerID, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun showMenu() {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, MenuFragment())
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
