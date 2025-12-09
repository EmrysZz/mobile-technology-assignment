package com.example.vehicleloanestimatorv1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val etPrice = findViewById<EditText>(R.id.etPrice)
        val etDownPayment = findViewById<EditText>(R.id.etDownPayment)
        val etPeriod = findViewById<EditText>(R.id.etPeriod)
        val etRate = findViewById<EditText>(R.id.etRate)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val btnBack = findViewById<ImageButton>(R.id.btnBack)

        val tvResultTitle = findViewById<TextView>(R.id.tvResultTitle)
        val cvResult = findViewById<CardView>(R.id.cvResult)
        val tvLoanAmount = findViewById<TextView>(R.id.tvLoanAmount)
        val tvTotalInterest = findViewById<TextView>(R.id.tvTotalInterest)
        val tvTotalPayment = findViewById<TextView>(R.id.tvTotalPayment)
        val tvMonthlyPayment = findViewById<TextView>(R.id.tvMonthlyPayment)

        btnBack.setOnClickListener {
            finish()
        }

        btnCalculate.setOnClickListener {
            val priceStr = etPrice.text.toString()
            val downStr = etDownPayment.text.toString()
            val periodStr = etPeriod.text.toString()
            val rateStr = etRate.text.toString()

            if (priceStr.isEmpty() || downStr.isEmpty() || periodStr.isEmpty() || rateStr.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (periodStr.toInt() == 0) {
                Toast.makeText(this, "Loan period cannot be zero.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val price = priceStr.toDouble()
            val downPayment = downStr.toDouble()

            if (downPayment > price) {
                Toast.makeText(this, "Down payment cannot be more than the vehicle price.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val result = LoanCalculation.calculate(
                price,
                downPayment,
                periodStr.toInt(),
                rateStr.toDouble()
            )

            tvLoanAmount.text = "RM %.2f".format(result.loanAmount)
            tvTotalInterest.text = "RM %.2f".format(result.totalInterest)
            tvTotalPayment.text = "RM %.2f".format(result.totalPayment)
            tvMonthlyPayment.text = "RM %.2f".format(result.monthlyPayment)

            tvResultTitle.visibility = View.VISIBLE
            cvResult.visibility = View.VISIBLE
        }
    }
}
