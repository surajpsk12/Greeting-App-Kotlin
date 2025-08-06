package com.surajvanshsv.greetingsapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.intellij.lang.annotations.Language

class MainActivity : AppCompatActivity() {

    //declaring the views
    lateinit var imageView : ImageView
    lateinit var nameEditText : EditText
    lateinit var languageEditText : EditText
    lateinit var buttonclick : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        nameEditText = findViewById(R.id.edittext_name)
        languageEditText = findViewById(R.id.editText)
        buttonclick = findViewById(R.id.buttonhello)

        // handling on button click
        buttonclick.setOnClickListener {
            // get name text
            var userName = nameEditText.text.toString()

            // get language text
            var languageSelected = languageEditText.text.toString()


            // say hello to user
            Toast.makeText(this,"Hello $userName , You selected $languageSelected",Toast.LENGTH_LONG).show()

            // set image according to language
            if(languageSelected.equals("Java")){
                imageView.setImageResource(R.drawable.javaimage)
            }else {
                imageView.setImageResource(R.drawable.kotlinimage)
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}