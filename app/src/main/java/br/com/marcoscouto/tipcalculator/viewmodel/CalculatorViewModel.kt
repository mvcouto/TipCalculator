package br.com.marcoscouto.tipcalculator.viewmodel

import android.app.Application
import android.databinding.BaseObservable
import br.com.marcoscouto.tipcalculator.R
import br.com.marcoscouto.tipcalculator.model.Calculator
import br.com.marcoscouto.tipcalculator.model.TipCalculation

class CalculatorViewModel(val app: Application, val calculator: Calculator = Calculator()) : BaseObservable() {

    var inputCheckAmount = ""
    var inputTipPercentage = ""

    var outputCheckAmount = ""
    var outputTipAmount = ""
    var outputTotalDollarAmount = ""

    init {
        updateOutputs(TipCalculation())
    }

    private fun updateOutputs(tc: TipCalculation) {
        outputCheckAmount = app.getString(R.string.dollar_amount, tc.checkAmount)
        outputTipAmount = app.getString(R.string.dollar_amount, tc.tipAmount)
        outputTotalDollarAmount = app.getString(R.string.dollar_amount, tc.grandTotal)
    }

    fun calculateTip() {

        val checkAmount = inputCheckAmount.toDoubleOrNull()
        val tipPct = inputTipPercentage.toIntOrNull()

        if (checkAmount != null && tipPct != null) {
            val tipCalculation = calculator.calculateTip(checkAmount, tipPct)
            updateOutputs(tipCalculation)
            clearInputs()
        }
    }

    fun clearInputs() {
        inputCheckAmount = "0.00"
        inputTipPercentage = "0"
        notifyChange()
    }
}