package com.example.vehicleloanestimatorv1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val etPrice = findViewById<EditText>(R.id.etPrice)
        val etDownPayment = findViewById<EditText>(R.id.etDownPayment)
        val etPeriod = findViewById<EditText>(R.id.etPeriod)
        val etRate = findViewById<EditText>(R.id.etRate)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        val btnBack = findViewById<ImageButton>(R.id.btnBack)

        //Add Back Logic
        btnBack.setOnClickListener {
            finish()
        }


        btnCalculate.setOnClickListener {
            val priceStr = etPrice.text.toString()
            val downStr = etDownPayment.text.toString()
            val periodStr = etPeriod.text.toString()
            val rateStr = etRate.text.toString()

            if (priceStr.isNotEmpty() && downStr.isNotEmpty() && periodStr.isNotEmpty() && rateStr.isNotEmpty()) {
                val result = LoanCalculation.calculate(
                    priceStr.toDouble(),
                    downStr.toDouble(),
                    periodStr.toInt(),
                    rateStr.toDouble()
                )

                tvResult.text = """
                    Loan Amount: RM %.2f
                    Total Interest: RM %.2f
                    Total Payment: RM %.2f
                    
                    Monthly Payment: RM %.2f
                """.trimIndent().format(result.loanAmount, result.totalInterest, result.totalPayment, result.monthlyPayment)
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}