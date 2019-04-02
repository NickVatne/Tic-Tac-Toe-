package no.student.nkv.ultimatetictactoe.screens


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_menu.*
import no.student.nkv.ultimatetictactoe.MainActivity
import no.student.nkv.ultimatetictactoe.R

class MenuFragment : Fragment() {

    private lateinit var singleplayer : Button
    private lateinit var multiplayer : Button
    private lateinit var highScore : Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fview = inflater.inflate(R.layout.fragment_menu, container, false)
        singleplayer = fview.findViewById(R.id.btnSingle)
        multiplayer = fview.findViewById(R.id.btnMulti)
        highScore = fview.findViewById(R.id.btnHighScore)

        return fview
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        singleplayer.setOnClickListener {
            val singleFrag = SingleplayerFragment()
            (activity as MainActivity).replaceFragment(R.id.fragment_container, singleFrag)
        }
        multiplayer.setOnClickListener {
            val multiFrag = MultiplayerFragment()
            (activity as MainActivity).replaceFragment(R.id.fragment_container, multiFrag)
        }
        highScore.setOnClickListener {
            val highScoreFrag = HighScoreFragment()
            (activity as MainActivity).replaceFragment(R.id.fragment_container, highScoreFrag)
        }



    }
}
