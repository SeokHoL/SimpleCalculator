package kr.ac.kopo.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //변수선언

    lateinit var edit1:EditText
    lateinit var edit2:EditText
    lateinit var btnPlus:Button
    lateinit var btnMinus:Button
    lateinit var btnMultiply:Button
    lateinit var btnDivide:Button
    lateinit var btnMod:Button
    lateinit var textResult:TextView
    var result : Double? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        //위젯 객체의 참조값을 필드로 선언된 참조변수에 대입

        edit1 =findViewById<EditText>(R.id.edit1)
        edit2 =findViewById<EditText>(R.id.edit2)
        btnPlus =findViewById<Button>(R.id.btnPlus)
        btnMinus =findViewById<Button>(R.id.btnMinus)
        btnMultiply =findViewById<Button>(R.id.btnMultiply)
        btnDivide =findViewById<Button>(R.id.btnDivide)
        btnMod =findViewById<Button>(R.id.btnMod)
        textResult =findViewById<TextView>(R.id.textResult)


        btnPlus.setOnClickListener(btnListener)
        btnMinus.setOnClickListener(btnListener)
        btnMultiply.setOnClickListener(btnListener)
        btnDivide.setOnClickListener(btnListener)
        btnMod.setOnClickListener(btnListener)


    }
    var btnListener =OnClickListener{
        var num1Str = edit1.text.toString()
        var num2Str = edit2.text.toString()

        if(num1Str == "" || num2Str == ""){       //if문 조건에 맞으면 토스트메시지(오류메시지 출력)
            Toast.makeText(baseContext, "입력을 하지 않았습니다.", Toast.LENGTH_LONG).show()
            return@OnClickListener  //이거 안쓰면 exception 발생.   @OnClickListener를 빠져나감
        }


        var num1  = num1Str.toDouble()   //문자를 숫자로 변환함
        var num2  = num2Str.toDouble()   //문자를 숫자로 변환함

        when(it.id){   //when이 swith문임
            R.id.btnPlus ->result = num1 + num2
            R.id.btnMinus ->result = num1 - num2
            R.id.btnMultiply ->result = num1 * num2
            R.id.btnDivide ->{
                if(num2 == 0.0){
                    Toast.makeText(baseContext, "0으로 나눌수 없습니다.",Toast.LENGTH_LONG).show()
                    return@OnClickListener
                }
                result = num1 / num2
            }
            R.id.btnMod ->{
                if(num2 == 0.0){
                    Toast.makeText(baseContext, "0으로 나눌수 없습니다.",Toast.LENGTH_LONG).show()
                    return@OnClickListener
                }
                result = num1 % num2
            }
        }

        textResult.text ="계산 결과: " + result
    }
}