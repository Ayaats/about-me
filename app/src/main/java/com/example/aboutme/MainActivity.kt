package com.example.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val myName: MyName = MyName("Aleks Haecky")

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName = myName
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //findViewById<Button>(R.id.done_button).setOnClickListener {
         //   addNickname(it)}
        binding.doneButton.setOnClickListener { addNickname(it) }
        }


    private fun addNickname(view:View){
        val editText= findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView=findViewById<TextView>(R.id.nickname_txt)
        //nicknameTextView.text=editText.text
        //editText.visibility=View.GONE
        //view.visibility=View.GONE
        //nicknameTextView.visibility=View.VISIBLE
        binding.apply {
            nicknameTxt.text=binding.nicknameEdit.text
            invalidateAll()
            editText.visibility=View.GONE
            view.visibility=View.GONE
            nicknameTextView.visibility=View.VISIBLE
            myName?.nickname = nicknameEdit.text.toString()
        }

    }
}