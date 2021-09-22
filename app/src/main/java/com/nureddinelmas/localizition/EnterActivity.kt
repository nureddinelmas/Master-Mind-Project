package com.nureddinelmas.localizition

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.nureddinelmas.localizition.databinding.ActivityEnterBinding
import android.view.LayoutInflater as LayoutInflater1

class EnterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEnterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        var enter_layout = findViewById<ConstraintLayout>(R.id.enter_layout)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        val animDrawable = enter_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()





        binding.root.setOnClickListener {
            val intent = Intent(this@EnterActivity, InputActivity::class.java)
            startActivity(intent)
        }






    }
}