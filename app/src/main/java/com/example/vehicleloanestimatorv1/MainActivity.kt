package com.example.vehicleloanestimatorv1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalc = findViewById<Button>(R.id.btnGoToCalculator)
        val btnAbout = findViewById<Button>(R.id.btnGoToAbout)
        val btnClose = findViewById<Button>(R.id.btnClose)

        btnCalc.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }

        btnAbout.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        //Close Logic
        btnClose.setOnClickListener {
            finishAffinity()
        }
    }
}