package com.nureddinelmas.localizition

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.nureddinelmas.localizition.databinding.ActivityMainBinding
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    var one : Boolean =false
    var two : Boolean =false
    var three : Boolean =false
    var four : Boolean =false

    var first : Int? = null
    var second : Int? = null
    var third : Int? = null
    var fourth : Int? = null

    var imageList = mutableListOf(R.drawable.blue, R.drawable.red, R.drawable.white, R.drawable.yellow)
    var imageListResult = mutableListOf(first, second, third, fourth)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        findColor()

        binding.one.setImageResource(imageListResult[0] as Int)
        binding.two.setImageResource(imageListResult[1] as Int)
        binding.three.setImageResource(imageListResult[2] as Int)
        binding.four.setImageResource(imageListResult[3] as Int)


        binding.one.setOnClickListener {
            binding.one.setImageResource(R.drawable.ic_launcher_background)
            one = false
        }

        binding.two.setOnClickListener {
            binding.two.setImageResource(R.drawable.ic_launcher_background)
            two = false
        }

        binding.three.setOnClickListener {
            binding.three.setImageResource(R.drawable.ic_launcher_background)
            three = false
        }

        binding.four.setOnClickListener {
            binding.four.setImageResource(R.drawable.ic_launcher_background)
            four = false
        }

        binding.red.setOnClickListener {
            if (!one){
                binding.one.setImageResource(imageList[1])
                one = true
                binding.one.tag ="red"
            }
            else if (!two){
                binding.two.setImageResource(imageList[1])
                two=true
                binding.two.tag = "red"
            }
            else if(!three){
                binding.three.setImageResource(imageList[1])
                three = true
                binding.textView.text = "Det blev röd på trean"
                binding.three.tag = "red"
            }
            else if(!four){
                binding.four.setImageResource(imageList[1])
                four = true
                binding.textView.text = "Det blev röd på fyran"
                binding.four.tag = "red"
            }
        }

        binding.white.setOnClickListener {
            if (!one){
                binding.one.setImageResource(imageList[2])
                one = true
                binding.one.tag = "white"
            }
            else if (!two){
                binding.two.setImageResource(imageList[2])
                two=true
                binding.two.tag = "white"
            }
            else if(!three){
                binding.three.setImageResource(imageList[2])
                three = true
                binding.textView.setText("Det blev vit på trean")
                binding.three.tag = "white"
            }
            else if(!four){
                binding.four.setImageResource(imageList[2])
                four = true
                binding.textView.setText("det blev vit på fyran")
                binding.four.tag = "white"
            }
        }

        binding.blue.setOnClickListener {
            if (!one){
                binding.one.setImageResource(imageList[0])
                one = true
                binding.one.tag = "blue"
            }
            else if (!two){
                binding.two.setImageResource(imageList[0])
                two = true
                binding.two.tag = "blue"
            }
            else if(!three){
                binding.three.setImageResource(imageList[0])
                three = true
                binding.three.tag = "blue"
            }
            else if(!four){
                binding.four.setImageResource(imageList[0])
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

        binding.button.setOnClickListener { checkIt() }

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

        binding.p1.setImageResource(imageList[0])
        binding.p2.setImageResource(imageList[1])
        binding.p3.setImageResource(imageList[2])
        binding.p4.setImageResource(imageList[3])

        if (fourth == imageList[3] && first == imageList[0] && second == imageList[1] && third == imageList[2]){
            binding.textView.setText("BRA JOBBAT!! KLART!!")
            binding.button.text = "Spel Igen"
        }else{
             binding.textView.setText("inte klart än")
            binding.button.text = "Försök Igen"
        }

    }


    fun createNewImageList(){
        println("${binding.one.tag}")
        println("${binding.two.tag}")
        println("${binding.three.tag}")
        println("${binding.four.tag}")


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

}

