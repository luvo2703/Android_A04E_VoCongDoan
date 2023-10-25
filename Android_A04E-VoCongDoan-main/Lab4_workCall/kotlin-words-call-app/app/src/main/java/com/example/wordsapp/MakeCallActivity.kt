package com.example.wordsapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MakeCallActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var buttonBack: Button
    private val PERMISSION_CODE = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.make_call)
        editText = findViewById(R.id.editTextPhone)
        button = findViewById(R.id.btnCall)
        buttonBack=findViewById(R.id.btnBack)
        check()
        button.setOnClickListener {
            val phoneNumber = editText.text.toString()
            if (phoneNumber.isNotEmpty()) {
                val callIntent = Intent(Intent.ACTION_CALL)
                callIntent.data = Uri.parse("tel:$phoneNumber")
                startActivity(callIntent)
                editText.setText("")
            }
        }
        buttonBack.setOnClickListener{
            val intent = Intent(this@MakeCallActivity,com.example.wordsapp.MainActivity::class.java)
            this@MakeCallActivity.startActivity(intent)
        }
    }

    private fun check() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
            != PackageManager.PERMISSION_GRANTED
        ) {

            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CALL_PHONE),
                PERMISSION_CODE
            )
        }
    }
}