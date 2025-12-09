package com.example.vehicleloanestimatorv1

data class LoanResult(
    val loanAmount: Double,
    val totalInterest: Double,
    val totalPayment: Double,
    val monthlyPayment: Double
)

object LoanCalculation {
    fun calculate(
        vehiclePrice: Double,
        downPayment: Double,
        periodYears: Int,
        interestRate: Double
    ): LoanResult {
        // Loan Amount = Price - Down Payment
        val loanAmount = vehiclePrice - downPayment

        // Total Interest = Loan Amount * (Rate/100) * Period
        val totalInterest = loanAmount * (interestRate / 100) * periodYears

        // Total Payment = Loan Amount + Interest
        val totalPayment = loanAmount + totalInterest

        val monthlyPayment = totalPayment / (periodYears * 12)

        return LoanResult(loanAmount, totalInterest, totalPayment, monthlyPayment)
    }
}