package com.example.tictactoegame

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoegame.databinding.ActivityMainBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {

    var player = "p1"

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this)

       val AdRequest = AdRequest.Builder().build()
        binding.adView.loadAd(AdRequest)


        binding.btn1.setOnClickListener(){
            buttonClick(binding.btn1)
        }
        binding.btn2.setOnClickListener(){
            buttonClick(binding.btn2)
        }
        binding.btn3.setOnClickListener(){
            buttonClick(binding.btn3)
        }
        binding.btn4.setOnClickListener(){
            buttonClick(binding.btn4)
        }
        binding.btn5.setOnClickListener(){
            buttonClick(binding.btn5)
        }
        binding.btn6.setOnClickListener(){
            buttonClick(binding.btn6)
        }
        binding.btn7.setOnClickListener(){
            buttonClick(binding.btn7)
        }
        binding.btn8.setOnClickListener(){
            buttonClick(binding.btn8)
        }
        binding.btn9.setOnClickListener(){
            buttonClick(binding.btn9)
        }

        binding.rstbtn.setOnClickListener(){
            reSet()
        }

    }

    fun buttonClick(btn:Button){
        if (btn.text == ""){
            if (player == "p1"){
                player = "p2"
                btn.text = "X"
            }else{
                player = "p1"
                btn.text = "O"
            }
        }
        win()
    }

    fun win(){
        if ((binding.btn1.text == "X" && binding.btn2.text == "X" && binding.btn3.text == "X")
            || (binding.btn4.text == "X" && binding.btn5.text == "X" && binding.btn6.text == "X")
            || (binding.btn7.text == "X" && binding.btn8.text == "X" && binding.btn9.text == "X")
            || (binding.btn1.text == "X" && binding.btn5.text == "X" && binding.btn9.text == "X")
            || (binding.btn3.text == "X" && binding.btn5.text == "X" && binding.btn7.text == "X")
            || (binding.btn1.text == "X" && binding.btn4.text == "X" && binding.btn7.text == "X")
            || (binding.btn2.text == "X" && binding.btn5.text == "X" && binding.btn8.text == "X")
            || (binding.btn3.text == "X" && binding.btn6.text == "X" && binding.btn9.text == "X")) {
            disableButtons()
            binding.textResult.text= "X won the game"
        }
        else if ((binding.btn1.text == "O" && binding.btn2.text == "O" && binding.btn3.text == "O")
            || (binding.btn4.text == "O" && binding.btn5.text == "O" && binding.btn6.text == "O")
            || (binding.btn7.text == "O" && binding.btn8.text == "O" && binding.btn9.text == "O")
            || (binding.btn1.text == "O" && binding.btn5.text == "O" && binding.btn9.text == "O")
            || (binding.btn3.text == "O" && binding.btn5.text == "O" && binding.btn7.text == "O")
            || (binding.btn1.text == "O" && binding.btn4.text == "O" && binding.btn7.text == "O")
            || (binding.btn2.text == "O" && binding.btn5.text == "O" && binding.btn8.text == "O")
            || (binding.btn3.text == "O" && binding.btn6.text == "O" && binding.btn9.text == "O")){
            disableButtons()
            binding.textResult.text= "O won the game"
        }
        else{
            if(binding.btn1.text != "" && binding.btn2.text != "" && binding.btn3.text != ""
                && binding.btn4.text != "" && binding.btn5.text != "" && binding.btn6.text != ""
                && binding.btn7.text != "" && binding.btn8.text != "" && binding.btn9.text != ""){
                binding.textResult.text = "Match Tied"
            }
        }

    }

    fun toast(msg: String){
        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
    }

    fun reSet(){
        binding.btn1.text=""
        binding.btn2.text=""
        binding.btn3.text=""
        binding.btn4.text=""
        binding.btn5.text=""
        binding.btn6.text=""
        binding.btn7.text=""
        binding.btn8.text=""
        binding.btn9.text=""

        binding.btn1.isEnabled=true
        binding.btn2.isEnabled=true
        binding.btn3.isEnabled=true
        binding.btn4.isEnabled=true
        binding.btn5.isEnabled=true
        binding.btn6.isEnabled=true
        binding.btn7.isEnabled=true
        binding.btn8.isEnabled=true
        binding.btn9.isEnabled=true
    }

    fun disableButtons(){
        binding.btn1.isEnabled=false
        binding.btn2.isEnabled=false
        binding.btn3.isEnabled=false
        binding.btn4.isEnabled=false
        binding.btn5.isEnabled=false
        binding.btn6.isEnabled=false
        binding.btn7.isEnabled=false
        binding.btn8.isEnabled=false
        binding.btn9.isEnabled=false
    }
}