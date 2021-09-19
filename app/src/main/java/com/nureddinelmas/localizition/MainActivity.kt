package com.nureddinelmas.localizition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.nureddinelmas.localizition.databinding.ActivityMainBinding

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

    var imageList = mutableListOf(R.drawable.red, R.drawable.white, R.drawable.blue, R.drawable.yellow)

    var imageListResult = mutableListOf(first, second, third, fourth)

    var imageLook = ArrayList<ResultLook>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        findColor()
/*
        binding.one.setImageResource(imageListResult[0] as Int)
        binding.two.setImageResource(imageListResult[1] as Int)
        binding.three.setImageResource(imageListResult[2] as Int)
        binding.four.setImageResource(imageListResult[3] as Int)

*/
        binding.one.setOnClickListener {
            binding.one.setImageResource(R.drawable.ic_launcher_background)
            one = false

            two = true
            three = true
            four = true

        }

        binding.two.setOnClickListener {
            binding.two.setImageResource(R.drawable.ic_launcher_background)
            two = false

            one = true
            three = true
            four = true
        }

        binding.three.setOnClickListener {
            binding.three.setImageResource(R.drawable.ic_launcher_background)
            three = false

            one = true
            two = true
            four = true
        }

        binding.four.setOnClickListener {
            binding.four.setImageResource(R.drawable.ic_launcher_background)
            four = false

            one = true
            two = true
            three = true
        }

        binding.red.setOnClickListener {
            if (!one){
                binding.one.setImageResource(imageList[0])
                one = true
                binding.one.tag ="red"
            }
            else if (!two){
                binding.two.setImageResource(imageList[0])
                two=true
                binding.two.tag = "red"
            }
            else if(!three){
                binding.three.setImageResource(imageList[0])
                three = true
                binding.three.tag = "red"
            }
            else if(!four){
                binding.four.setImageResource(imageList[0])
                four = true
                binding.four.tag = "red"
            }
        }

        binding.white.setOnClickListener {
            if (!one){
                binding.one.setImageResource(imageList[1])
                one = true
                binding.one.tag = "white"
            }
            else if (!two){
                binding.two.setImageResource(imageList[1])
                two=true
                binding.two.tag = "white"
            }
            else if(!three){
                binding.three.setImageResource(imageList[1])
                three = true
                binding.three.tag = "white"
            }
            else if(!four){
                binding.four.setImageResource(imageList[1])
                four = true
                binding.four.tag = "white"
            }
        }

        binding.blue.setOnClickListener {
            if (!one){
                binding.one.setImageResource(imageList[2])
                one = true
                binding.one.tag = "blue"
            }
            else if (!two){
                binding.two.setImageResource(imageList[2])
                two = true
                binding.two.tag = "blue"
            }
            else if(!three){
                binding.three.setImageResource(imageList[2])
                three = true
                binding.three.tag = "blue"
            }
            else if(!four){
                binding.four.setImageResource(imageList[2])
                four = true
                binding.four.tag = "blue"
            }
        }

        binding.yellow.setOnClickListener {
            if (!one){
                binding.one.setImageResource(imageList[3])
                one = true
                binding.one.tag = "yellow"
            }
            else if (!two){
              binding.two.setImageResource(imageList[3])
                two = true
                binding.two.tag = "yellow"
            }
            else if(!three){
               binding.three.setImageResource(imageList[3])
                three = true
                binding.three.tag = "yellow"
            }
            else if(!four){
               binding.four.setImageResource(imageList[3])
                four = true
                binding.four.tag = "yellow"
            }
        }

        binding.button.setOnClickListener{ checkIt() }

    }

    private fun findColor() {


        var n1 = (0..3).random()
        var n2 = (0..3).random()
        while (n1 == n2){
            n2 = (0..3).random()
        }

        var n3 = (0..3).random()
        while (n3 == n1 || n3 == n2){
           n3 = (0..3).random()
        }

        var n4 = (0..3).random()
        while (n4 == n1 || n4 == n2 || n4 == n3 ){
            n4 = (0..3).random()
        }


        when(n1){
            0 -> first = R.drawable.white
             1 -> first = R.drawable.red
            2 -> first = R.drawable.yellow
             3 -> first = R.drawable.blue
        }

        when(n2){
            0 -> second = R.drawable.white
            1 -> second = R.drawable.red
            2 -> second = R.drawable.yellow
            3 -> second = R.drawable.blue
        }

        when(n3){
            0 -> third = R.drawable.white
            1 -> third = R.drawable.red
            2 -> third = R.drawable.yellow
            3 -> third = R.drawable.blue
        }

        when(n4){
            0 -> fourth = R.drawable.white
            1 -> fourth = R.drawable.red
            2 -> fourth = R.drawable.yellow
            3 -> fourth = R.drawable.blue
        }
            imageListResult = mutableListOf(first,second,third,fourth)

    }

    private fun checkIt(){


        createNewImageList()

        if (fourth != imageList[3]){
            wrong += 1
        }

        if (first != imageList[0]){
            wrong += 1
        }
        if (second != imageList[1]){
            wrong += 1
        }
        if (third != imageList[2]){
            wrong += 1
        }

        if (fourth == imageList[3] && first == imageList[0] && second == imageList[1] && third == imageList[2]){
            binding.textView.text = "BRA JOBBAT!! KLART!!"
            binding.button.text = "Spel Igen"
        }else{
            binding.button.text = "Ett Försök Till"
            binding.textView.text = "inte klart än du har $wrong felplace"
            ettForsokTill()
        }

    }


    private fun createNewImageList(){

        when(binding.one.tag){
            "red" -> imageList[0] = R.drawable.red
            "white" -> imageList[0] = R.drawable.white
            "blue" -> imageList[0] = R.drawable.blue
            "yellow" -> imageList[0] = R.drawable.yellow
        }
        when(binding.two.tag){
            "red" -> imageList[1] = R.drawable.red
            "white" -> imageList[1] = R.drawable.white
            "blue" -> imageList[1] = R.drawable.blue
            "yellow" -> imageList[1] = R.drawable.yellow
        }
        when(binding.three.tag){
            "red" -> imageList[2] = R.drawable.red
            "white" -> imageList[2] = R.drawable.white
            "blue" -> imageList[2] = R.drawable.blue
            "yellow" -> imageList[2] = R.drawable.yellow
        }
        when(binding.four.tag){
            "red" -> imageList[3] = R.drawable.red
            "white" -> imageList[3] = R.drawable.white
            "blue" -> imageList[3] = R.drawable.blue
            "yellow" -> imageList[3] = R.drawable.yellow
        }
    }

    private fun  ettForsokTill(){


        imageLook.add(ResultLook(imageList[0], imageList[1], imageList[2], imageList[3]))

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ResultAdapter(imageLook)
        binding.recyclerView.adapter = adapter

    }

}