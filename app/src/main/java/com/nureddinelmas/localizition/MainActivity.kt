package com.nureddinelmas.localizition

import android.annotation.SuppressLint
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
                imageList[0] = R.drawable.red
            }
            else if (!two){
                binding.two.setImageResource(imageList[1])
                two=true
                imageList[1] = R.drawable.red

            } else if(!three){
                binding.three.setImageResource(imageList[1])
                three = true
                imageList[2] = R.drawable.red
                binding.textView.text = "ucuncu kirmizi oldu"
            }else{
                binding.four.setImageResource(imageList[1])
                four = true
                imageList[3] = R.drawable.red
                binding.textView.text = "dorduncu kirmizi oldu"
            }
        }

        binding.white.setOnClickListener {
            if (!one){
                binding.one.setImageResource(imageList[2])
                one = true
                imageList[2] = R.drawable.white
            }
            else if (!two){
                binding.two.setImageResource(imageList[2])
                two=true
                imageList[2] = R.drawable.white
            } else if(!three){
                binding.three.setImageResource(imageList[2])
                three = true
                imageList[2] = R.drawable.white
                binding.textView.text = "ucuncu beyaz oldu"
            }else{
                binding.four.setImageResource(imageList[2])
                four = true
                imageList[2] = R.drawable.white
                binding.textView.text = "dorduncu beyaz oldu"
            }
        }

        binding.blue.setOnClickListener {
            if (!one){
                binding.one.setImageResource(imageList[0])
                one = true
                imageList[0] = R.drawable.blue
            }
            else if (!two){
                binding.two.setImageResource(imageList[0])
                two = true
                imageList[0] = R.drawable.blue
            }else if(!three){
                binding.three.setImageResource(imageList[0])
                three = true
                imageList[0] = R.drawable.blue
            }else{
                binding.four.setImageResource(imageList[0])
                four = true
                imageList[0] = R.drawable.blue
            }
        }

        binding.yellow.setOnClickListener {
            if (!one){
                binding.one.setImageResource(imageList[3])
                one = true
                imageList[3] = R.drawable.yellow
            }
            else if (!two){
              binding.two.setImageResource(imageList[3])
                two = true
                imageList[3] = R.drawable.yellow

            }else if(!three){
               binding.three.setImageResource(imageList[3])
                three = true
                imageList[3] = R.drawable.yellow
            }else{
               binding.four.setImageResource(imageList[3])
                four = true
                imageList[3] = R.drawable.yellow
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


    }

    private fun checkIt(){

        if (fourth == imageList[3] || first == imageList[0] || second == imageList[1] || third == imageList[2]){
            binding.textView.text = "klart"
            binding.textView2.text = "$fourth == ${imageList[3]} || $first == ${imageList[0]} || $second == ${imageList[1]} || $third == ${imageList[2]}"
        }else{

       binding.textView.text = "inte klart än"

        binding.textView2.text = " ${imageList[0]} & ${imageList[3]} & ${imageList[3]} & ${imageList[3]}  ve  = $first ve $second ve $third ve $fourth "

        }
    }



}

