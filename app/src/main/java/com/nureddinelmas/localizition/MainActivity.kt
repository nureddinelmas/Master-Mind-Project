package com.nureddinelmas.localizition

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.MotionEvent
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.nureddinelmas.localizition.databinding.ActivityMainBinding
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    var one : Boolean =false
    var two : Boolean =false
    var three : Boolean =false
    var four : Boolean =false


    var first : Int = 0
    var second : Int = 0
    var third : Int = 0
    var fourth : Int = 0

    var wrong = 0
    var right = 0

    lateinit var player1 : String
    lateinit var player2 : String
    var player : String = ""
    var playerKontrol : Int = 0

    var imageList = mutableListOf(
        R.drawable.red,
        R.drawable.white,
        R.drawable.blue,
        R.drawable.yellow,
        R.drawable.black,
        R.drawable.green
    )

    var imageListResult = mutableListOf(first, second, third, fourth)

    var imageLook = ArrayList<ResultLook>()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        val intent = intent
        val entre = intent.getIntExtra("info", 0)
        player1 = intent.getStringExtra("player1").toString()
        player2 = intent.getStringExtra("player2").toString()
        if (entre == 1){
            playerChoose(player1, player2)
            binding.button.text = "${player} är det din tur!"
            timer.start()
        }

        findColor()

        binding.root.setOnTouchListener { view, motionEvent ->
            when(motionEvent.action){
                MotionEvent.ACTION_UP -> {
                    binding.one.setImageResource(R.drawable.question)
                    binding.two.setImageResource(R.drawable.question)
                    binding.three.setImageResource(R.drawable.question)
                    binding.four.setImageResource(R.drawable.question)}
                MotionEvent.ACTION_DOWN -> {
                    binding.one.setImageResource(imageListResult[0] as Int)
                    binding.two.setImageResource(imageListResult[1] as Int)
                    binding.three.setImageResource(imageListResult[2] as Int)
                    binding.four.setImageResource(imageListResult[3] as Int)}
            }
            true
        }

        binding.one.setOnClickListener {
            binding.one.setImageResource(R.drawable.question)
            one = false

            two = true
            three = true
            four = true

        }

        binding.two.setOnClickListener {
            binding.two.setImageResource(R.drawable.question)
            two = false

            one = true
            three = true
            four = true
        }

        binding.three.setOnClickListener {
            binding.three.setImageResource(R.drawable.question)
            three = false

            one = true
            two = true
            four = true
        }

        binding.four.setOnClickListener {
            binding.four.setImageResource(R.drawable.question)
            four = false

            one = true
            two = true
            three = true
        }

        binding.red.setOnClickListener {
            if (!one){
                binding.one.setImageResource(R.drawable.red)
                one = true
                binding.one.tag ="red"
            }
            else if (!two){
                binding.two.setImageResource(R.drawable.red)
                two=true
                binding.two.tag = "red"
            }
            else if(!three){
                binding.three.setImageResource(R.drawable.red)
                three = true
                binding.three.tag = "red"
            }
            else if(!four){
                binding.four.setImageResource(R.drawable.red)
                four = true
                binding.four.tag = "red"
            }
        }

        binding.white.setOnClickListener {
            if (!one){
                binding.one.setImageResource(R.drawable.white)
                one = true
                binding.one.tag = "white"
            }
            else if (!two){
                binding.two.setImageResource(R.drawable.white)
                two=true
                binding.two.tag = "white"
            }
            else if(!three){
                binding.three.setImageResource(R.drawable.white)
                three = true
                binding.three.tag = "white"
            }
            else if(!four){
                binding.four.setImageResource(R.drawable.white)
                four = true
                binding.four.tag = "white"
            }
        }

        binding.blue.setOnClickListener {
            if (!one){
                binding.one.setImageResource(R.drawable.blue)
                one = true
                binding.one.tag = "blue"
            }
            else if (!two){
                binding.two.setImageResource(R.drawable.blue)
                two = true
                binding.two.tag = "blue"
            }
            else if(!three){
                binding.three.setImageResource(R.drawable.blue)
                three = true
                binding.three.tag = "blue"
            }
            else if(!four){
                binding.four.setImageResource(R.drawable.blue)
                four = true
                binding.four.tag = "blue"
            }
        }

        binding.yellow.setOnClickListener {
            if (!one){
                binding.one.setImageResource(R.drawable.yellow)
                one = true
                binding.one.tag = "yellow"
            }
            else if (!two){
              binding.two.setImageResource(R.drawable.yellow)
                two = true
                binding.two.tag = "yellow"
            }
            else if(!three){
               binding.three.setImageResource(R.drawable.yellow)
                three = true
                binding.three.tag = "yellow"
            }
            else if(!four){
               binding.four.setImageResource(R.drawable.yellow)
                four = true
                binding.four.tag = "yellow"
            }
        }

        binding.black.setOnClickListener {
            if (!one){
                binding.one.setImageResource(R.drawable.black)
                one = true
                binding.one.tag = "black"
            }
            else if (!two){
                binding.two.setImageResource(R.drawable.black)
                two = true
                binding.two.tag = "black"
            }
            else if(!three){
                binding.three.setImageResource(R.drawable.black)
                three = true
                binding.three.tag = "black"
            }
            else if(!four){
                binding.four.setImageResource(R.drawable.black)
                four = true
                binding.four.tag = "black"
            }
        }

        binding.green.setOnClickListener {
            if (!one){
                binding.one.setImageResource(R.drawable.green)
                one = true
                binding.one.tag = "green"
            }
            else if (!two){
                binding.two.setImageResource(R.drawable.green)
                two = true
                binding.two.tag = "green"
            }
            else if(!three){
                binding.three.setImageResource(R.drawable.green)
                three = true
                binding.three.tag = "green"
            }
            else if(!four){
                binding.four.setImageResource(R.drawable.green)
                four = true
                binding.four.tag = "green"
            }
        }

        binding.button.setOnClickListener{

            when (binding.button.text) {
                "Play Again" -> {
                    binding.button.text = "Check It !"
                     imageLook.clear()

                }
                "Play Now" -> {binding.button.text = "${player} är det din tur!"
                }
                "Check It !" -> {
                    playerKontrol += 1
                    playerChoose(player1,player2)
                    checkIt()
                   timer.start()
                }
                "${player} är det din tur!" -> {
                    timer.start()
                    oneMoreTime()
                    checkIt()
                    playerChoose(player1,player2)
                }
            }
                }
    }

    private fun findColor() {


        var n1 = (0..5).random()
        var n2 = (0..5).random()
        while (n1 == n2){
            n2 = (0..5).random()
        }

        var n3 = (0..5).random()
        while (n3 == n1 || n3 == n2){
           n3 = (0..5).random()
        }

        var n4 = (0..5).random()
        while (n4 == n1 || n4 == n2 || n4 == n3 ){
            n4 = (0..5).random()
        }

        var n5 = (0..5).random()
        while(n5 == n1 || n5 == n2 || n5 == n3 || n5 == n4){
            n5 = (0..5).random()
        }

        var n6 = (0..5).random()
        while(n6 == n1 || n6 == n2 || n6 == n3 || n6 == n4 || n6 == n5){
            n6 = (0..5).random()
        }


        when(n1){
            0 -> first = R.drawable.white
             1 -> first = R.drawable.red
            2 -> first = R.drawable.yellow
             3 -> first = R.drawable.blue
            4 -> first = R.drawable.black
            5 -> first = R.drawable.green
        }

        when(n2){
            0 -> second = R.drawable.white
            1 -> second = R.drawable.red
            2 -> second = R.drawable.yellow
            3 -> second = R.drawable.blue
            4 -> second = R.drawable.black
            5 -> second = R.drawable.green
        }

        when(n3){
            0 -> third = R.drawable.white
            1 -> third = R.drawable.red
            2 -> third = R.drawable.yellow
            3 -> third = R.drawable.blue
            4 -> third = R.drawable.black
            5 -> third = R.drawable.green

        }

        when(n4){
            0 -> fourth = R.drawable.white
            1 -> fourth = R.drawable.red
            2 -> fourth = R.drawable.yellow
            3 -> fourth = R.drawable.blue
            4 -> fourth == R.drawable.black
            5 -> fourth = R.drawable.green
        }
            imageListResult = mutableListOf(first,second,third,fourth)

    }

    private fun checkIt(){

        wrong = 0
        right = 0
        createNewImageList()

        // Om det finns ingen färg så ska visas bara
        if (imageList[0] != first && imageList[0] != second && imageList[0] != third && imageList[0] != fourth){
            wrong += 1
        }

        if (imageList[1] != first && imageList[1] != second && imageList[1] != third && imageList[1] != fourth){
            wrong += 1
        }

        if (imageList[2] != first && imageList[2] != second && imageList[2] != third && imageList[2] != fourth){
            wrong += 1
        }

        if (imageList[3] != first && imageList[3] != second && imageList[3] != third && imageList[3] != fourth){
            wrong += 1
        }

        // Right answer we check
        if (fourth == imageList[3]){
            right += 1
        }

        if (first == imageList[0]){
            right += 1
        }
        if (second == imageList[1]){
            right == 1
        }
        if (third == imageList[2]){
            right += 1
        }

        if (fourth == imageList[3] && first == imageList[0] && second == imageList[1] && third == imageList[2]){
            Snackbar.make(binding.root,"BRA JOBBAT!!! ${player}! Du vann!! ::)) ", Snackbar.LENGTH_INDEFINITE).setAction("Exit? ", View.OnClickListener {
                finish()
                exitProcess(0)}).show()
            binding.button.text = "Play Again"
            findColor()

        }else{
            Snackbar.make(binding.root,"${player}! misslyckades :(( ", Snackbar.LENGTH_LONG).setAction("Exit?", View.OnClickListener { exitProcess(0) }).show()
            // binding.button.text = "${player} är det din tur!"

        }

    }

    private fun createNewImageList(){

        when(binding.one.tag){
            "red" -> imageList[0] = R.drawable.red
            "white" -> imageList[0] = R.drawable.white
            "blue" -> imageList[0] = R.drawable.blue
            "yellow" -> imageList[0] = R.drawable.yellow
            "black" -> imageList[0] = R.drawable.black
            "green" -> imageList[0] = R.drawable.green
        }
        when(binding.two.tag){
            "red" -> imageList[1] = R.drawable.red
            "white" -> imageList[1] = R.drawable.white
            "blue" -> imageList[1] = R.drawable.blue
            "yellow" -> imageList[1] = R.drawable.yellow
            "black" -> imageList[1] = R.drawable.black
            "green" -> imageList[1] = R.drawable.green
        }
        when(binding.three.tag){
            "red" -> imageList[2] = R.drawable.red
            "white" -> imageList[2] = R.drawable.white
            "blue" -> imageList[2] = R.drawable.blue
            "yellow" -> imageList[2] = R.drawable.yellow
            "black" -> imageList[2] = R.drawable.black
            "green" -> imageList[2] = R.drawable.green
        }
        when(binding.four.tag){
            "red" -> imageList[3] = R.drawable.red
            "white" -> imageList[3] = R.drawable.white
            "blue" -> imageList[3] = R.drawable.blue
            "yellow" -> imageList[3] = R.drawable.yellow
            "black" -> imageList[3] = R.drawable.black
            "green" -> imageList[3] = R.drawable.green
        }
    }

    private fun  oneMoreTime(){
        imageLook.add(ResultLook(imageList[0], imageList[1], imageList[2], imageList[3], "$wrong Wrong", "$right Right", "$player"))

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ResultAdapter(imageLook)
        binding.recyclerView.adapter = adapter

    }

    private fun playerChoose(player1 : String, player2: String) : String{
        player = if (playerKontrol % 2 == 0){
            player1
        }else{
            player2
        }
        return player
    }

    val timer = object : CountDownTimer(15000,1000) {
        override fun onTick(millisUntilFinished: Long) {
            binding.button.text = "$player! Du har ${millisUntilFinished/1000} seconder"
            playerKontrol += 1
        }

        override fun onFinish() {
            binding.button.text =  "${player} är det din tur!"
        }

    }

}
