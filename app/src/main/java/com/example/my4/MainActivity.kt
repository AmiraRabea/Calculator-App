package com.example.my4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var isNewop=true
    fun buNumberEvent(view:View){
        if(isNewop){
            tvShowNember.text=""
        }
        isNewop=false
        var tvshownumber:String=tvShowNember.text.toString()
        val buSelect =view as Button
        when(buSelect.id){
            bu0.id->{tvshownumber+="0"}
            bu1.id->{tvshownumber+="1"}
            bu2.id->{tvshownumber+="2"}
            bu3.id->{tvshownumber+="3"}
            bu4.id->{tvshownumber+="4"}
            bu5.id->{tvshownumber+="5"}
            bu6.id->{tvshownumber+="6"}
            bu7.id->{tvshownumber+="7"}
            bu8.id->{tvshownumber+="8"}
            bu9.id->{tvshownumber+="9"}
            budot.id->{tvshownumber+="."}
            buplusminus.id->{ tvshownumber="-" + tvshownumber}
        }
        tvShowNember.text=tvshownumber

    }

    var oldnumber=""
    var op="+"
    fun buOpEvent(view: View){
        oldnumber=tvShowNember.text.toString()
        isNewop=true
        val buselect=view as Button
        when(buselect.id){
            budiv.id -> {op= "/"}
            bumul.id -> {op= "*"}
            bunimus.id -> {op= "-"}
            buplus.id -> {op= "+"}
            bumodlus.id -> {op= "%"}
        }

    }

    fun buEqualEvent(view: View){
        val newnumber=tvShowNember.text.toString()
        var finiaNumber:Double?=null
        when(op){
            "/" ->{
                if (newnumber.toDouble()!=0.0){finiaNumber=oldnumber.toDouble()/newnumber.toDouble()}else{tvShowNember.text="Invalid Number"}
            }
            "*" ->{finiaNumber=oldnumber.toDouble()*newnumber.toDouble()}
            "-" ->{finiaNumber=oldnumber.toDouble()-newnumber.toDouble()}
            "+" ->{finiaNumber=oldnumber.toDouble()+newnumber.toDouble()}
            "%" ->{
                finiaNumber=oldnumber.toDouble()/newnumber.toDouble()
                finiaNumber=finiaNumber-finiaNumber.toInt()
                finiaNumber=finiaNumber*newnumber.toDouble()
            }
    }
        tvShowNember.text=finiaNumber.toString()
        isNewop=true
    }

    fun buClear(view: View){
        isNewop=true
        tvShowNember.text="0"
    }
}