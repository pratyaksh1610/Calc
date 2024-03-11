package com.pratyakshkhurana.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.pratyakshkhurana.calculator.Fragments.CalculatorFragment
import com.pratyakshkhurana.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var calculatorFragment: CalculatorFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calculatorFragment = CalculatorFragment()
        loadFragment(calculatorFragment, CalculatorFragment()::class.java.name)

        Toast.makeText(this, "Reached main activity", Toast.LENGTH_SHORT).show()
    }

    private fun loadFragment(fragment: Fragment, tag: String? = null) {
        if (fragment is CalculatorFragment) {
            supportFragmentManager.popBackStack(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragment)
            addToBackStack(tag)
            commit()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }
}
