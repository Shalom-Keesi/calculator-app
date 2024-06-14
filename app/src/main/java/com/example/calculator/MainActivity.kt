package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnAdd.setOnClickListener{
           validate("+")
        }
        binding.btnSubtract.setOnClickListener{
            validate("-")

        }
        binding.btnMultiply.setOnClickListener{
          validate("*")

        }
        binding.btnDivide.setOnClickListener{
            validate("/")
        }

    }


    fun validate(operation: String){
        val num1 = binding.etNum1.text.toString()
        val num2 = binding.etNum2.text.toString()
        var error = false
        if (num1.isBlank()){
            error=true
            binding.etNum1.error = "Num1 is required"
        }
        if (num2.isBlank()){
            error=true
            binding.etNum2.error = "Num2 is required"
        }
        if(!error){
            calculate(num1.toDouble(),num2.toDouble(),operation)
        }

    }

    fun calculate(num1:Double, num2:Double,operation:String){
        var result = 0.0

        when (operation){
            "+"->{
                result=num1+num2

            }
            "-"->{
                result=num1-num2

            }
            "*"->{
                result=num1*num2

            }
            "/"->{
                result=num1/num2

            }
        }
        binding.tvResult.text=result.toString()

    }
}