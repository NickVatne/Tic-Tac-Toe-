package no.student.nkv.ultimatetictactoe.screens

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import kotlinx.android.synthetic.main.fragment_multiplayer.*
import kotlinx.android.synthetic.main.gamelogic_multiplayer.*
import no.student.nkv.ultimatetictactoe.R
import no.student.nkv.ultimatetictactoe.gameLogic.GameLogicMultiplayer


class MultiplayerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fieldview = inflater.inflate(R.layout.fragment_multiplayer, container, false)
        return fieldview
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        BtnStart.setOnClickListener {
            val intent = Intent(activity, GameLogicMultiplayer::class.java)
            startActivity(intent)
        }
        fun getInput() {
            val editTextPlayerOne = (R.id.playerOneName) as EditText
            editTextPlayerOne.toString()

            val editTextPlayerTwo: EditText = (R.id.playerTwoName) as EditText
            editTextPlayerTwo.toString()
        }
    }
}

