package no.student.nkv.ultimatetictactoe.gameLogic

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.gamelogic_multiplayer.*
import no.student.nkv.ultimatetictactoe.R
import no.student.nkv.ultimatetictactoe.screens.SplashScreenActivity

class GameLogicMultiplayer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gamelogic_multiplayer)
        var chance = "X"
        var board = arrayListOf<String>("", "", "", "", "", "", "", "", "")

        timer.start()

        button0.setOnClickListener {
            if (board[0] != "")
            else if (chance == "X") {
                button0.text = "X"
                board[0] = "X"
                chance = "O"
            } else {
                button0.text = "O"
                board[0] = "O"
                chance = "X"
            }
            resultOut(board)
        }

        button1.setOnClickListener {
            if (board[1] != "")
            else if (chance == "X") {
                button1.text = "X"
                board[1] = "X"
                chance = "O"
            } else {
                button1.text = "O"
                board[1] = "O"
                chance = "X"
            }
            resultOut(board)
        }

        button2.setOnClickListener {
            if (board[2] != "")
            else if (chance == "X") {
                button2.text = "X"
                board[2] = "X"
                chance = "O"
            } else {
                button2.text = "O"
                board[2] = "O"
                chance = "X"
            }
            resultOut(board)
        }

        button3.setOnClickListener {
            if (board[3] != "")
            else if (chance == "X") {
                button3.text = "X"
                board[3] = "X"
                chance = "O"
            } else {
                button3.text = "O"
                board[3] = "O"
                chance = "X"
            }
            resultOut(board)
        }

        button4.setOnClickListener {
            if (board[4] != "")
            else if (chance == "X") {
                button4.text = "X"
                board[4] = "X"
                chance = "O"
            } else {
                button4.text = "O"
                board[4] = "O"
                chance = "X"
            }
            resultOut(board)
        }

        button5.setOnClickListener {
            if (board[5] != "")
            else if (chance == "X") {
                button5.text = "X"
                board[5] = "X"
                chance = "O"
            } else {
                button5.text = "O"
                board[5] = "O"
                chance = "X"
            }
            resultOut(board)
        }

        button6.setOnClickListener {
            if (board[6] != "")
            else if (chance == "X") {
                button6.text = "X"
                board[6] = "X"
                chance = "O"
            } else {
                button6.text = "O"
                board[6] = "O"
                chance = "X"
            }
            resultOut(board)
        }

        button7.setOnClickListener {
            if (board[7] != "")
            else if (chance == "X") {
                button7.text = "X"
                board[7] = "X"
                chance = "O"
            } else {
                button7.text = "O"
                board[7] = "O"
                chance = "X"
            }
            resultOut(board)
        }

        button8.setOnClickListener {
            if (board[8] != "")
            else if (chance == "X") {
                button8.text = "X"
                board[8] = "X"
                chance = "O"
            } else {
                button8.text = "O"
                board[8] = "O"
                chance = "X"
            }
            resultOut(board)
        }
        imageViewQuit.setOnClickListener {
            finish()
            moveTaskToBack(true)
        }

    }

    private fun resultOut(board: ArrayList<String>) {
        if (result(board, "X")) {
            startActivity(Intent(this@GameLogicMultiplayer, SplashScreenActivity::class.java).putExtra("Nicolai", "X"))
        } else if (result(board, "O")) {
            startActivity(Intent(this@GameLogicMultiplayer, SplashScreenActivity::class.java).putExtra("TTbot", "O"))
        }
        if (isBoardFull(board)) {
            startActivity(Intent(this@GameLogicMultiplayer, SplashScreenActivity::class.java).putExtra("Nobody", "Tie"))
        }
    }

    private fun isBoardFull(board: ArrayList<String>): Boolean {
        for (i in board)
            if (i != "X" && i != "O") return false
        return true
    }

    private fun result(bd: ArrayList<String>, s: String): Boolean =
        if (bd[0] == s && bd[1] == s && bd[2] == s) true
        else if (bd[3] == s && bd[4] == s && bd[5] == s) true
        else if (bd[6] == s && bd[7] == s && bd[8] == s) true
        else if (bd[0] == s && bd[3] == s && bd[6] == s) true
        else if (bd[1] == s && bd[4] == s && bd[7] == s) true
        else if (bd[2] == s && bd[5] == s && bd[8] == s) true
        else if (bd[0] == s && bd[4] == s && bd[8] == s) true
        else bd[2] == s && bd[4] == s && bd[6] == s

}
