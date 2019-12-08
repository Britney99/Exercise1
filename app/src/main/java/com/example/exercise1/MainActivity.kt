package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculateButton: Button = findViewById(R.id.buttonCalculate)
        val resetButton: Button = findViewById(R.id.buttonReset)

        calculateButton.setOnClickListener { calculate() }
        resetButton.setOnClickListener{ reset() }
    }

    private fun calculate(){
        val carpriceInput: EditText = findViewById(R.id.editTextCarPrice)
        val downpaymentInput: EditText = findViewById(R.id.editTextDownPayment)
        val loanperiodInput: EditText  = findViewById(R.id.editTextLoanPeriod)
        val interestRateInput: EditText = findViewById(R.id.editTextInterestRate)
        val carloan: TextView  = findViewById(R.id.textViewLoan)
        val interest: TextView = findViewById(R.id.textViewInterest)
        val monthlyrepayment: TextView = findViewById(R.id.textViewMonthlyRepayment)

        val carloanAns = Integer.parseInt(carpriceInput.text.toString()) - Integer.parseInt(downpaymentInput.text.toString())
        val interestAns = Integer.parseInt(carloanAns.toString()) * Integer.parseInt(interestRateInput.text.toString()) * Integer.parseInt(loanperiodInput.text.toString())
        val monthlyrepaymentAns = (Integer.parseInt(carloanAns.toString()) + Integer.parseInt(interestAns.toString())) / Integer.parseInt(loanperiodInput.text.toString()) / 12

        carloan.setText("Loan: "+carloanAns.toString())
        interest.setText("Interest: "+interestAns.toString())
        monthlyrepayment.setText("Monthly Repayment: "+monthlyrepaymentAns)


    }

    private fun reset(){
        val carpriceInput: EditText = findViewById(R.id.editTextCarPrice)
        val downpaymentInput: EditText = findViewById(R.id.editTextDownPayment)
        val loanperiodInput: EditText  = findViewById(R.id.editTextLoanPeriod)
        val interestRateInput: EditText = findViewById(R.id.editTextInterestRate)
        val carloan: TextView  = findViewById(R.id.textViewLoan)
        val interest: TextView = findViewById(R.id.textViewInterest)
        val monthlyrepayment: TextView = findViewById(R.id.textViewMonthlyRepayment)
        carpriceInput.setText("");
        downpaymentInput.setText("");
        loanperiodInput.setText("");
        interestRateInput.setText("");

        carloan.setText("Loan:");
        interest.setText("Interst:");
        monthlyrepayment.setText("Monthly Repayment:");
    }
}