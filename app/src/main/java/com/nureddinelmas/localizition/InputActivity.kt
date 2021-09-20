package com.nureddinelmas.localizition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nureddinelmas.localizition.databinding.ActivityInputBinding

class InputActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (binding.editTextTextPersonName.text.equals("") || binding.editTextTextPersonName2.text.equals("")){
            binding.editTextTextPersonName.error = "Enter a player name!!"
            binding.editTextTextPersonName2.error = "Enter a player name!!"
        }


        binding.button.setOnClickListener{
            val intent = Intent(this@InputActivity, MainActivity::class.java)
            intent.putExtra("info", 1)
            intent.putExtra("player1", binding.editTextTextPersonName.text.toString())
            intent.putExtra("player2", binding.editTextTextPersonName2.text.toString())
            startActivity(intent)
            finish()
        }
    }
}