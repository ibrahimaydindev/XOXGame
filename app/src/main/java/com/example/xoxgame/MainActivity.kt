package com.example.xoxgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.sosgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding
    private var firstTurn = Turn.CROSS
    private var currentTurn = Turn.CROSS
    private var firstScore = 0
    private var secondScore = 0
    private var boardList = mutableListOf<Button>()

    enum class Turn {
        NOUGHT,
        CROSS
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        initBoard()

        binding.resetButton.setOnClickListener {
            for (i in 0..35) {
                boardList[i].text = ""
                boardList[i].isEnabled = true
            }
            currentTurn = firstTurn
        }
    }

    private fun initBoard() {
        boardList.add(binding.button1)
        boardList.add(binding.button2)
        boardList.add(binding.button3)
        boardList.add(binding.button4)
        boardList.add(binding.button5)
        boardList.add(binding.button6)
        boardList.add(binding.button7)
        boardList.add(binding.button8)
        boardList.add(binding.button9)
        boardList.add(binding.button10)
        boardList.add(binding.button11)
        boardList.add(binding.button12)
        boardList.add(binding.button13)
        boardList.add(binding.button14)
        boardList.add(binding.button15)
        boardList.add(binding.button16)
        boardList.add(binding.button17)
        boardList.add(binding.button18)
        boardList.add(binding.button19)
        boardList.add(binding.button20)
        boardList.add(binding.button21)
        boardList.add(binding.button22)
        boardList.add(binding.button23)
        boardList.add(binding.button24)
        boardList.add(binding.button25)
        boardList.add(binding.button26)
        boardList.add(binding.button27)
        boardList.add(binding.button28)
        boardList.add(binding.button29)
        boardList.add(binding.button30)
        boardList.add(binding.button31)
        boardList.add(binding.button32)
        boardList.add(binding.button33)
        boardList.add(binding.button34)
        boardList.add(binding.button35)
        boardList.add(binding.button36)
    }

    private fun checkVictory(s: String): Boolean {
        if (match(binding.button1, s) && match(binding.button2, s) && match(
                binding.button3,
                s
            ) && match(binding.button4, s) && match(binding.button5, s) && match(binding.button6, s)
        )
            return true
        if (match(binding.button7, s) && match(binding.button8, s) && match(
                binding.button9,
                s
            ) && match(binding.button10, s) && match(binding.button11, s) && match(
                binding.button12,
                s
            )
        )
            return true
        if (match(binding.button13, s) && match(binding.button14, s) && match(
                binding.button15,
                s
            ) && match(binding.button16, s) && match(binding.button17, s) && match(
                binding.button18,
                s
            )
        )
            return true
        if (match(binding.button19, s) && match(binding.button20, s) && match(
                binding.button21,
                s
            ) && match(binding.button22, s) && match(binding.button23, s) && match(
                binding.button24,
                s
            )
        )
            return true
        if (match(binding.button25, s) && match(binding.button26, s) && match(
                binding.button27,
                s
            ) && match(binding.button28, s) && match(binding.button29, s) && match(
                binding.button30,
                s
            )
        )
            return true
        if (match(binding.button31, s) && match(binding.button32, s) && match(
                binding.button33,
                s
            ) && match(binding.button34, s) && match(binding.button35, s) && match(
                binding.button36,
                s
            )
        )
            return true
        if (match(binding.button1, s) && match(binding.button7, s) && match(
                binding.button13,
                s
            ) && match(binding.button19, s) && match(binding.button25, s) && match(
                binding.button31,
                s
            )
        )
            return true
        if (match(binding.button2, s) && match(binding.button8, s) && match(
                binding.button14,
                s
            ) && match(binding.button20, s) && match(binding.button26, s) && match(
                binding.button32,
                s
            )
        )
            return true
        if (match(binding.button3, s) && match(binding.button9, s) && match(
                binding.button15,
                s
            ) && match(binding.button21, s) && match(binding.button27, s) && match(
                binding.button33,
                s
            )
        )
            return true
        if (match(binding.button4, s) && match(binding.button10, s) && match(
                binding.button16,
                s
            ) && match(binding.button22, s) && match(binding.button28, s) && match(
                binding.button34,
                s
            )
        )
            return true
        if (match(binding.button5, s) && match(binding.button11, s) && match(
                binding.button17,
                s
            ) && match(binding.button23, s) && match(binding.button29, s) && match(
                binding.button35,
                s
            )
        )
            return true
        if (match(binding.button6, s) && match(binding.button12, s) && match(
                binding.button28,
                s
            ) && match(binding.button24, s) && match(binding.button30, s) && match(
                binding.button36,
                s
            )
        )
            return true
        if (match(binding.button1, s) && match(binding.button8, s) && match(
                binding.button15,
                s
            ) && match(binding.button22, s) && match(binding.button28, s) && match(
                binding.button36,
                s
            )
        )
            return true
        if (match(binding.button6, s) && match(binding.button11, s) && match(
                binding.button16,
                s
            ) && match(binding.button21, s) && match(binding.button26, s) && match(
                binding.button31,
                s
            )
        )
            return true
        return false
    }

    private fun result(title: String) {
        val message = "\nPlayer One: $firstScore\n\nPlayer Two: $secondScore"
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("Reset")
            { _, _ ->
                resetBoard()
            }
            .setCancelable(false)
            .show()
    }

    private fun match(button: Button, symbol: String): Boolean = button.text == symbol
    fun resetBoard() {
        for (button in boardList) {
            button.text = ""
        }
        if (firstTurn == Turn.NOUGHT)
            firstTurn = Turn.CROSS
        else if (firstTurn == Turn.CROSS)
            firstTurn = Turn.NOUGHT

        currentTurn = firstTurn
        setTurnLabel()
    }

    fun boardTapped(view: View) {
        if (view !is Button)
            return
        addToBoard(view)

        if (checkVictory(ONE)) {
            firstScore++
            result("Player One Won")
        } else if (checkVictory(TWO)) {
            secondScore++
            result("Player Two Won")

        } else if (fullBoard()) {
            result("Draw")
        }
    }

    private fun fullBoard(): Boolean {
        for (button in boardList) {
            if (button.text == "")
                return false
        }
        return true
    }

    private fun addToBoard(button: Button) {
        if (button.text != "")
            return
        if (currentTurn == Turn.NOUGHT) {
            button.text = "X"
            currentTurn = Turn.CROSS
        } else if (currentTurn == Turn.CROSS) {
            button.text = "O"
            currentTurn = Turn.NOUGHT
        }
        setTurnLabel()
    }

    private fun setTurnLabel() {
        var turnText = ""
        if (currentTurn == Turn.CROSS) {
            turnText = "Player O Turn"
        } else if (currentTurn == Turn.NOUGHT) {
            turnText = "Player X Turn"
        }
        binding.textView.text = turnText
    }

    companion object {
        const val ONE = "X"
        const val TWO = "O"
    }
}