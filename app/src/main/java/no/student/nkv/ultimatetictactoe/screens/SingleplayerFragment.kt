package no.student.nkv.ultimatetictactoe.screens

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_singleplayer.*
import no.student.nkv.ultimatetictactoe.R
import no.student.nkv.ultimatetictactoe.gameLogic.GameLogicSinglePlayer


class SingleplayerFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val Viewmf = inflater.inflate(R.layout.fragment_singleplayer, container, false)
        return Viewmf
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        BtnStart.setOnClickListener {
            val intent = Intent(activity, GameLogicSinglePlayer::class.java)
            startActivity(intent)
        }
    }

}
