package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferences.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
   lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        val sh =getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val s1 = sh.getString("name","")
        val a = sh.getInt("age",0)

        binding.key.setText(s1)
        binding.value.setText(a.toString())
    }

    override fun onPause() {
        super.onPause()
        val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val myEdit = sharedPreferences.edit()

        myEdit.putString("name",binding.key.text.toString())
        myEdit.putInt("age",binding.value.text.toString().toInt())
        myEdit.apply()
    }
}


