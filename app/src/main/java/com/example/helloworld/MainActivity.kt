package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import java.security.Key
import java.time.temporal.ValueRange

class MainActivity : AppCompatActivity() {
    var clickCount=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val clickCountDisplayValue = findViewById<TextView>(R.id.clickCountView)
        val clickMeButton = findViewById<TextView>(R.id.clickButton)
        val userNameTextInputView=findViewById<TextInputLayout>(R.id.nameText)
        val nameMap= mutableMapOf<String,Int>()
        clickMeButton.setOnClickListener()
        {

            val username=userNameTextInputView.editText?.text?.toString()
            var markedUserName=if(username.isNullOrEmpty()) "Somebody"
            else username
            if(markedUserName in nameMap)
            {
                clickCount= nameMap[markedUserName.toString()]!!
                nameMap[markedUserName.toString()]=clickCount+1
            }
            else
            {
                nameMap.put(markedUserName.toString(),+1)
            }
            clickCountDisplayValue.text = "$markedUserName clicked ${nameMap[markedUserName]} times"
        }
    }
}