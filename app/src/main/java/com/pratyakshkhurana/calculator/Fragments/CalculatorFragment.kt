package com.pratyakshkhurana.calculator.Fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pratyakshkhurana.calculator.databinding.FragmentCalculatorBinding
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorFragment : Fragment() {
    private lateinit var binding: FragmentCalculatorBinding
    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            evaluateExpression()
        }

        override fun afterTextChanged(s: Editable?) {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCalculatorBinding.inflate(layoutInflater, container, false)
        binding.etInput.addTextChangedListener(textWatcher)
        evaluateExpression()

        binding.btnClear.setOnClickListener {
            clearInput()
        }
        binding.btnEquals.setOnClickListener {
            evaluateExpression()
        }
        binding.btn0.setOnClickListener {
            appendToInput("0")
        }

        binding.btn1.setOnClickListener {
            appendToInput("1")
        }
        binding.btn2.setOnClickListener {
            appendToInput("2")
        }
        binding.btn3.setOnClickListener {
            appendToInput("3")
        }
        binding.btn4.setOnClickListener {
            appendToInput("4")
        }
        binding.btn5.setOnClickListener {
            appendToInput("5")
        }
        binding.btn6.setOnClickListener {
            appendToInput("6")
        }
        binding.btn7.setOnClickListener {
            appendToInput("7")
        }
        binding.btn8.setOnClickListener {
            appendToInput("8")
        }
        binding.btn9.setOnClickListener {
            appendToInput("9")
        }
        binding.btnDecimal.setOnClickListener {
            appendToInput(".")
        }
        binding.btnMultiplication.setOnClickListener {
            appendToInput("*")
        }
        binding.btnDivision.setOnClickListener {
            appendToInput("/")
        }
        binding.btnAddition.setOnClickListener {
            appendToInput("+")
        }
        binding.btnSubtraction.setOnClickListener {
            appendToInput("-")
        }
        binding.btnNegativePositive.setOnClickListener {
            var res = binding.tvOutput.text.toString()
            if (res[0] == '-') {
                res = res.removePrefix("-")
            } else {
                res = "-$res"
            }
            binding.tvOutput.text = res
        }
        binding.btnPercentage.setOnClickListener {
            var res = binding.tvOutput.text.toString().toDouble()
            res /= 100
            binding.tvOutput.text = res.toString()
        }

        return binding.root
    }

    private fun appendToInput(str: String) {
        binding.etInput.text.append(str)
    }

    private fun evaluateExpression() {
        if (binding.etInput.text.toString().isNotEmpty()) {
            try {
                val eval = ExpressionBuilder(binding.etInput.text.toString()).build()
                val res = eval.evaluate()
                setResult(res.toString())
            } catch (_: Exception) {
            }
        }
    }

    private fun setResult(res: String) {
        binding.tvOutput.text = res
    }

    private fun clearInput() {
        binding.etInput.setText("")
    }
}
