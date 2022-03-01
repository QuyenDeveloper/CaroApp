package com.example.game_caro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buClick(view: View) {

        val buSelected:Button = view as Button

        var cellId = 0
        when(buSelected.id){
            R.id.bu1->cellId = 1
            R.id.bu2->cellId = 2
            R.id.bu3->cellId = 3
            R.id.bu4->cellId = 4
            R.id.bu5->cellId = 5
            R.id.bu6->cellId = 6
            R.id.bu7->cellId = 7
            R.id.bu8->cellId = 8
            R.id.bu9->cellId = 9
        }

//        Log.d("buClick:", buSelected.id.toString())
//        Log.d("buClick: cellId", cellId.toString())
        playGame(cellId, buSelected)

    }

    var acticePlayer = 1

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun playGame ( cellId: Int, buSelected: Button){

        if(acticePlayer == 1){
            buSelected.text = "X"
            buSelected.setBackgroundResource(R.color.blue)
            player1.add(cellId)
            acticePlayer = 2

            autoPlayer()

        }else{
            buSelected.text = "O"
            buSelected.setBackgroundResource(R.color.red)
            player2.add(cellId)
            acticePlayer = 1
        }

        buSelected.isEnabled = false

        checkwinner()

    }

    fun checkwinner(){

        var winer = -1

        //row1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winer = 1
        }
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winer = 1
        }
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winer = 1
        }
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winer = 1
        }
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winer = 1
        }
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winer = 1
        }

        //row2
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winer = 2
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winer = 2
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winer = 2
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winer = 2
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winer = 2
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winer = 2
        }

        if (winer == 1){
            Toast.makeText(this, "Player 1 win the game", Toast.LENGTH_LONG).show()
        }else if(winer == 2){
            Toast.makeText(this, "Player 2 win the game", Toast.LENGTH_LONG).show()
        }

    }

    fun autoPlayer(){

        var emptyCells = ArrayList<Int>()
        for (cellId:Int in  1..9){
            if ( !(player1.contains(cellId)  ||  player2.contains(cellId))){
                emptyCells.add(cellId)
            }
        }

        val r = Random()
        val randIndex = r.nextInt(emptyCells.size)
        val cellId = emptyCells[randIndex]

        var buSelected:Button?
        val bu1: Button = findViewById(R.id.bu1)
        val bu2: Button = findViewById(R.id.bu2)
        val bu3: Button = findViewById(R.id.bu3)
        val bu4: Button = findViewById(R.id.bu4)
        val bu5: Button = findViewById(R.id.bu5)
        val bu6: Button = findViewById(R.id.bu6)
        val bu7: Button = findViewById(R.id.bu7)
        val bu8: Button = findViewById(R.id.bu8)
        val bu9: Button = findViewById(R.id.bu9)
        buSelected = when(cellId){
            1 -> bu1
            2 -> bu2
            3 -> bu3
            4 -> bu4
            5 -> bu5
            6 -> bu6
            7 -> bu7
            8 -> bu8
            9 -> bu9
            else -> {bu1}
        }

        playGame(cellId, buSelected)

    }
}