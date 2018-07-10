package br.com.marcoscouto.tipcalculator.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.marcoscouto.tipcalculator.R
import br.com.marcoscouto.tipcalculator.databinding.ActivityTipCalculatorBinding
import br.com.marcoscouto.tipcalculator.viewmodel.CalculatorViewModel

class TipCalculatorActivity : AppCompatActivity() {

    lateinit var binding: ActivityTipCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_tip_calculator)
        binding.vm = CalculatorViewModel(application)

        setSupportActionBar(binding.toolbar)
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        return when (item.itemId) {
//            R.id.action_settings -> true
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
}
