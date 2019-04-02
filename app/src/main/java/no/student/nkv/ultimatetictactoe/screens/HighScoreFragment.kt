package no.student.nkv.ultimatetictactoe.screens

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import no.student.nkv.ultimatetictactoe.MainActivity
import no.student.nkv.ultimatetictactoe.R

class HighScoreFragment : Fragment() {

    private lateinit var btnMenu : Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewmd = inflater.inflate(R.layout.fragment_high_score, container, false)
        btnMenu = viewmd.findViewById(R.id.btnMenu)
        return viewmd
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnMenu.setOnClickListener {
            (activity as MainActivity).showMenu()
        }

    }
}
