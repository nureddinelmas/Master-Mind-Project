package com.nureddinelmas.localizition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nureddinelmas.localizition.databinding.ActivityInputBinding


class InputActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.inputButton.setOnClickListener{
            if (binding.playerOneEditText.text.toString() != "" && binding.playerTwoEditText.text.toString() != ""){

                val intent = Intent(this@InputActivity, MainActivity::class.java)
                intent.putExtra("info", 1)
                intent.putExtra("player1", binding.playerOneEditText.text.toString())
                intent.putExtra("player2", binding.playerTwoEditText.text.toString())
                startActivity(intent)
                finish()

            } else{
                binding.playerOneEditText.error = "Enter a player name!!"
                binding.playerTwoEditText.error = "Enter a player name!!"
            }
        }
    }
}