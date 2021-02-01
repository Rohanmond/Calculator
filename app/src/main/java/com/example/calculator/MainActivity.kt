package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception
import kotlin.math.exp

class MainActivity : AppCompatActivity() {
    lateinit var one:TextView
    lateinit var two:TextView
    lateinit var three:TextView
    lateinit var four:TextView
    lateinit var five:TextView
    lateinit var six:TextView
    lateinit var seven:TextView
    lateinit var eight:TextView
    lateinit var nine:TextView
    lateinit var zero:TextView
    lateinit var plusOperator:TextView
    lateinit var minusOperator:TextView
    lateinit var multiplyOperator:TextView
    lateinit var divideOperator:TextView
    lateinit var percentOperator:TextView
    lateinit var acOperator:TextView
    lateinit var backspaceOperator:ImageView
    lateinit var dotOperator:TextView
    lateinit var equalOperator:TextView
    lateinit var signChangeOperator:TextView
    lateinit var result:TextView
    lateinit var expression:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        one=findViewById(R.id.one)
        two=findViewById(R.id.two)
        three=findViewById(R.id.three)
        four=findViewById(R.id.four)
        five=findViewById(R.id.five)
        six=findViewById(R.id.six)
        seven=findViewById(R.id.seven)
        eight=findViewById(R.id.eight)
        nine=findViewById(R.id.nine)
        zero=findViewById(R.id.zero)
        plusOperator=findViewById(R.id.addition)
        minusOperator=findViewById(R.id.minus)
        multiplyOperator=findViewById(R.id.product)
        divideOperator=findViewById(R.id.dividant)
        percentOperator=findViewById(R.id.percent)
        acOperator=findViewById(R.id.acButton)
        backspaceOperator=findViewById(R.id.backspaceButton)
        dotOperator=findViewById(R.id.dot)
        equalOperator=findViewById(R.id.equal)
        signChangeOperator=findViewById(R.id.signChange)
        result=findViewById(R.id.result)
        expression=findViewById(R.id.expression)
        one.setOnClickListener {
            expressionBuilder("1",true)
        }
        two.setOnClickListener {
            expressionBuilder("2",true)
        }
        three.setOnClickListener {
            expressionBuilder("3",true)
        }
        four.setOnClickListener {
            expressionBuilder("4",true)
        }
        five.setOnClickListener {
            expressionBuilder("5",true)
        }
        six.setOnClickListener {
            expressionBuilder("6",true)
        }
        seven.setOnClickListener {
            expressionBuilder("7",true)
        }
        eight.setOnClickListener {
            expressionBuilder("8",true)
        }
        nine.setOnClickListener {
            expressionBuilder("9",true)
        }
        zero.setOnClickListener {
            expressionBuilder("0",true)
        }
        plusOperator.setOnClickListener {
            expressionBuilder("+",false)

        }
        minusOperator.setOnClickListener {
            expressionBuilder("-",false)

        }
        multiplyOperator.setOnClickListener {
            expressionBuilder("*",false)
        }
        divideOperator.setOnClickListener {
            expressionBuilder("/",false)
        }
        percentOperator.setOnClickListener {
            expressionBuilder("%",false)
        }
        signChangeOperator.setOnClickListener {
            if(result.text.startsWith('-')) {
                result.text = result.text.substring(1,result.text.length-1)
                expression.text=expression.text.substring(1,expression.text.length-1)
            }else if(expression.text==""){
                expression.append("-")
            }
            else{
                result.text="-"+result.text
                expression.text="-"+"("+expression.text+")"
            }
        }
        acOperator.setOnClickListener {
            result.text="0"
            expression.text=""
        }
        backspaceOperator.setOnClickListener{
            if(result.text.isNotEmpty()){
                result.text=result.text.substring(0,result.text.length-1)
                expression.text=result.text
            }
        }

        equalOperator.setOnClickListener {
            try {
                var equalResult=ExpressionBuilder(expression.text.toString()).build().evaluate()
                result.text=equalResult.toString()
                expression.text=result.text
            }catch (e:Exception){
               // Toast.makeText(applicationContext, "${e.message}", Toast.LENGTH_SHORT).show()
                result.text=e.message
            }
        }
        dotOperator.setOnClickListener {
            result.append(".")
            expression.append(".")
        }
    }
    fun expressionBuilder(symbol:String,replace:Boolean){
        try {
            if (result.text.toString().equals("0")) {
                if (replace) {
                    result.text = symbol
                    expression.append(symbol)
                } else {
                    expression.text = result.text.toString() + symbol
                }
            } else {
                if (replace) {
                    expression.append(symbol)
                    result.append(symbol)

                } else {

                    expression.append(symbol)
                    result.text = "0"
                }
            }
        }catch (e:Exception){
            result.text=e.toString()
        }

    }

}