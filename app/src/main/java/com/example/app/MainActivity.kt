package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast.*
import com.example.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding : ActivityMainBinding ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding!!.root)


        var buton = binding!!.btnStart
        var textarea = binding!!.etName

        buton.setOnClickListener {
            if(textarea.text.toString().isEmpty())
            {
                textarea.setError("please enter a name")
                makeText(this, "Please enter you name", LENGTH_LONG).show()
            }else{
                Handler().postDelayed({
                    startActivity(Intent(this, QuestionsActivity::class.java))
                }, 2000)
                intent.putExtra(Constants.USER_NAME, binding!!.etName.text.toString())
            }
        }
    }
}