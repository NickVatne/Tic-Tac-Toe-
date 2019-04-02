package no.student.nkv.ultimatetictactoe.gameLogic

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.gamelogic_singleplayer.*
import no.student.nkv.ultimatetictactoe.R
import no.student.nkv.ultimatetictactoe.screens.SplashScreenActivity
import java.util.*

class GameLogicSinglePlayer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gamelogic_singleplayer)
        timer.start()

        // Deklarer en array for brettet av mulige knapper som empty x9
        var board = arrayListOf<String>("", "", "", "", "", "", "", "", "")

        button0.setOnClickListener {
            gamelogic0(board)
        }

        button1.setOnClickListener {
            gamelogic1(board)
        }

        button2.setOnClickListener {
            gamelogic2(board)
        }

        button3.setOnClickListener {
            gamelogic3(board)
        }

        button4.setOnClickListener {
            gamelogic4(board)
        }

        button5.setOnClickListener {
            gamelogic5(board)
        }

        button6.setOnClickListener {
            gamelogic6(board)
        }

        button7.setOnClickListener {
            gamelogic7(board)
        }

        button8.setOnClickListener {
            gamelogic8(board)
        }
        imageViewQuit.setOnClickListener {
            finish()
            moveTaskToBack(true)
        }

    }

    private fun gamelogic8(board: ArrayList<String>) {
        when {
            board[8] == "" -> {
                button8.text = "X"
                board[8] = "X"
                if (!boardIsNotFull(board) && !result(board, "X")) {
                    val position = computerMakesaMove(board)
                    board[position] = "O"
                    displayComputerButton(position)
                }
            }
        }
        giveResult(board)
    }

    private fun gamelogic7(board: ArrayList<String>) {
        when {
            board[7] == "" -> {
                button7.text = "X"
                board[7] = "X"
                if (!boardIsNotFull(board) && !result(board, "X")) {
                    val position = computerMakesaMove(board)
                    board[position] = "O"
                    displayComputerButton(position)
                }
            }
        }
        giveResult(board)
    }

    private fun gamelogic6(board: ArrayList<String>) {
        when {
            board[6] == "" -> {
                button6.text = "X"
                board[6] = "X"
                if (!boardIsNotFull(board) && !result(board, "X")) {
                    val position = computerMakesaMove(board)
                    board[position] = "O"
                    displayComputerButton(position)
                }
            }
        }
        giveResult(board)
    }

    private fun gamelogic5(board: ArrayList<String>) {
        when {
            board[5] == "" -> {
                button5.text = "X"
                board[5] = "X"
                if (!boardIsNotFull(board) && !result(board, "X")) {
                    val position = computerMakesaMove(board)
                    board[position] = "O"
                    displayComputerButton(position)
                }
            }
        }
        giveResult(board)
    }

    private fun gamelogic4(board: ArrayList<String>) {
        when {
            board[4] == "" -> {
                button4.text = "X"
                board[4] = "X"
                if (!boardIsNotFull(board) && !result(board, "X")) {
                    val position = computerMakesaMove(board)
                    board[position] = "O"
                    displayComputerButton(position)
                }
            }
        }
        giveResult(board)
    }

    private fun gamelogic3(board: ArrayList<String>) {
        when {
            board[3] == "" -> {
                button3.text = "X"
                board[3] = "X"
                if (!boardIsNotFull(board) && !result(board, "X")) {
                    val position = computerMakesaMove(board)
                    board[position] = "O"
                    displayComputerButton(position)
                }
            }
        }
        giveResult(board)
    }

    private fun gamelogic2(board: ArrayList<String>) {
        when {
            board[2] == "" -> {
                button2.text = "X"
                board[2] = "X"
                if (!boardIsNotFull(board) && !result(board, "X")) {
                    val position = computerMakesaMove(board)
                    board[position] = "O"
                    displayComputerButton(position)
                }
            }
        }
        giveResult(board)
    }

    private fun gamelogic1(board: ArrayList<String>) {
        when {
            board[1] == "" -> {
                button1.text = "X"
                board[1] = "X"
                if (!this.boardIsNotFull(board) && !result(board, "X")) {
                    val position = this.computerMakesaMove(board)
                    board[position] = "O"
                    displayComputerButton(position)
                }
            }
        }
        giveResult(board)
    }

    private fun gamelogic0(board: ArrayList<String>) {
        when {
            board[0] == "" -> {
                button0.text = "X"
                board[0] = "X"
                if (!boardIsNotFull(board) && !result(board, "X")) {
                    val position = computerMakesaMove(board)
                    board[position] = "O"
                    displayComputerButton(position)
                }
            }
        }
        giveResult(board)
    }


    //
    private fun computerMakesaMove(board: ArrayList<String>): Int {

        //Se hvis datamaskinen kan vinne med dette bevegelse
        for (i in 0..board.count() - 1) {
            var copy: ArrayList<String> = getBoardCopy(board)
            if (copy[i] == "") copy[i] = "O"
            if (result(copy, "O")) return i
        }

        // Se hvis player kan vinne med denne bevegelsen
        for (i in 0..board.count() - 1) {
            var copy2 = getBoardCopy(board)
            if (copy2[i] == "") copy2[i] = "X"
            if (result(copy2, "X")) return i
        }

        // Prøv å ta hjørnene hvis de er tilgjengelig
        var move = choseRandomMove(board, arrayListOf<Int>(0, 2, 6, 8))
        if (move != -1)
            return move

        //try to take center if its free
        if (board[4] == "") return 4

        //move on one of the sides
        return choseRandomMove(board, arrayListOf<Int>(1, 3, 5, 7))
    }


    // Bruk informasjonen tilgjengelig for å gjøre et tilfeldig random move
    private fun choseRandomMove(board: ArrayList<String>, list: ArrayList<Int>): Int {
        var possibleMoves = arrayListOf<Int>()
        for (i in list) {
            if (board[i] == "") possibleMoves.add(i)
        }
        if (possibleMoves.isEmpty()) return -1
        else {
            var index = Random().nextInt(possibleMoves.count())
            return possibleMoves[index]
        }
    }

    // Denne metoden brukes for å få en kopi av brettet slik at maskinen kan gjøre et valg på hvor han skal plassere neste tic. Alt dette lages inn i en arraylist som igjen brukes for neste logiske move
    private fun getBoardCopy(board: ArrayList<String>): ArrayList<String> {
        var bd = arrayListOf<String>("", "", "", "", "", "", "", "", "")
        for (i in 0..board.count() - 1) {
            bd[i] = board[i]
        }
        return bd
    }

    // Logisk metode for å sjekke om brettet er fylt opp.
    private fun boardIsNotFull(board: ArrayList<String>): Boolean {
        for (i in board)
            if (i != "X" && i != "O") return false
        return true
    }


    private fun giveResult(board: ArrayList<String>) {
        if (result(board, "X")) {
            startActivity(
                Intent(this@GameLogicSinglePlayer, SplashScreenActivity::class.java).putExtra(
                    "player",
                    "YOU"
                )
            )
        } else if (result(board, "O")) {
            startActivity(
                Intent(this@GameLogicSinglePlayer, SplashScreenActivity::class.java).putExtra(
                    "player",
                    "COMPUTER"
                )
            )
        }
        if (boardIsNotFull(board)) {
            startActivity(
                Intent(this@GameLogicSinglePlayer, SplashScreenActivity::class.java).putExtra(
                    "player",
                    "Tie"
                )
            )
        }
    }

    // Mulige resultatkombinasjoner som du kan vinne med.
    private fun result(bd: ArrayList<String>, s: String): Boolean =
        when {
            bd[0] == s && bd[1] == s && bd[2] == s -> true
            bd[3] == s && bd[4] == s && bd[5] == s -> true
            bd[6] == s && bd[7] == s && bd[8] == s -> true
            bd[0] == s && bd[3] == s && bd[6] == s -> true
            bd[1] == s && bd[4] == s && bd[7] == s -> true
            bd[2] == s && bd[5] == s && bd[8] == s -> true
            bd[0] == s && bd[4] == s && bd[8] == s -> true
            else -> bd[2] == s && bd[4] == s && bd[6] == s
        }

    // Legg til text ikonet for hva datamaskinen velger å gjøre
    private fun displayComputerButton(position: Int) {
        when (position) {
            0 -> button0.text = "O"
            1 -> button1.text = "O"
            2 -> button2.text = "O"
            3 -> button3.text = "O"
            4 -> button4.text = "O"
            5 -> button5.text = "O"
            6 -> button6.text = "O"
            7 -> button7.text = "O"
            8 -> button8.text = "O"
        }
    }

}


