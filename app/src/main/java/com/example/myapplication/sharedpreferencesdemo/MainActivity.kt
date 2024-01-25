package com.example.myapplication.sharedpreferencesdemo

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.sharedpreferencesdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences=getSharedPreferences("Notedata",Context.MODE_PRIVATE)
        binding.SaveNotebutton.setOnClickListener {
            val note=binding.etNotes.text.toString()
            val sharededit=sharedPreferences.edit()
            sharededit.putString("note",note)
            sharededit.apply()
            Toast.makeText(this,"Note stored succesfully",Toast.LENGTH_LONG).show()
            binding.etNotes.text.clear()
        }

        binding.displaynotebutton.setOnClickListener {
            val storenote=sharedPreferences.getString("note","")
            binding.txtdisplay.text=storenote
        }
    }
}