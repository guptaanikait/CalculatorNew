package com.example.calculatornew

import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.TextUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var edittext=findViewById<EditText>(R.id.displayEditText)
        edittext.inputType= InputType.TYPE_NULL
        val button0=findViewById<Button>(R.id.button0)
        val button1=findViewById<Button>(R.id.button1)
        val button2=findViewById<Button>(R.id.button2)
        val button3=findViewById<Button>(R.id.button3)
        val button4=findViewById<Button>(R.id.button4)
        val button5=findViewById<Button>(R.id.button5)
        val button6=findViewById<Button>(R.id.button6)
        val button7=findViewById<Button>(R.id.button7)
        val button8=findViewById<Button>(R.id.button8)
        val button9=findViewById<Button>(R.id.button9)
        val clearbutton=findViewById<Button>(R.id.clearButton)
        val dividebutton=findViewById<Button>(R.id.divideButton)
        val multiplybutton=findViewById<Button>(R.id.multiplyButton)
        val addbutton=findViewById<Button>(R.id.addButton)
        val subbutton=findViewById<Button>(R.id.subtractButton)
        val dotbutton=findViewById<Button>(R.id.dotButton)
        val equalbutton=findViewById<Button>(R.id.equalButton)

        var flag0=0 //for checking if there is one zero in left side and . is not entered so multiple zero should not be there in left
        var flag1=0 //for checking if a . is entered so other should not be entered
        var flag2=0 //for checking if a integer part is entered so . should not come before that
        //var flag3=0 //for the operators button should not work until a integer is entered and if . is entered then another integer is entered
        var flag4=0 //to check if only a 0 is entered
        var first=0.0
        var second=0.0
        var opn=""
        var ans=0.0
        var flag5=0 //for 1st -ve term
        var flag6=0 //for 2nd -ve term
        var flag7=0 //if enter is typed

        clearbutton.setOnClickListener {
            edittext.setText("")
            edittext.hint="0"
            flag7=0
        }
        button0.setOnClickListener {

            if(flag4==0){
                flag4=1 //only 0 is entered
            }
            if(flag0==0){
                var help=edittext.text.toString()
                help+="0"
                edittext.setText(help)
                flag0=1 //means one zero in lhs
                flag2=1
            }
            if(flag0==2){
                var help=edittext.text.toString()
                help+="0"
                edittext.setText(help)
                //flag0=1
            }
        }
        dotbutton.setOnClickListener {
            flag4=2 //. is also entered
            if(flag1==0){ //if . is not entered
                if(flag0==1){
                    flag0=2 //means a . is entered so other 0 can come
                }
                if(flag2==0){ //means integer part is not entered so add 0.
                    var help=edittext.text.toString()
                    //if(help=="-"){
                    // help+="-0."
                    //}
                    //else{
                    help+="0."
                    //}
                    edittext.setText(help)
                    flag1=1 //. is entered
                    flag2=1 //integer part is entered now
                }
                else {
                    var help = edittext.text.toString()
                    help += "."
                    edittext.setText(help)
                    flag1 = 1
                }
                //flag3=1

            }
        }
        button1.setOnClickListener {
            if(flag4==1  && edittext.text.toString()!="-0"){
                edittext.text.clear() //01 case only 1 should come
            }
            if(flag0==0){
                flag0=2 //100 case
            }
            if(flag2==0){
                flag2=1
            }
            var help=edittext.text.toString()
            if(help=="-0"){
                edittext.setText("-1")
                flag4=2
            }
            else {
                help += "1"
                edittext.setText(help)
                flag4 = 2
            }
        }
        button2.setOnClickListener {
            if(flag4==1 && edittext.text.toString()!="-0"){
                edittext.text.clear()
            }
            if(flag0==0){
                flag0=2
            }
            if(flag2==0){
                flag2=1
            }

            var help = edittext.text.toString()
            if(help=="-0"){
                edittext.setText("-2")
                flag4=2
            }
            else {
                help += "2"
                edittext.setText(help)
                flag4 = 2
            }
        }
        button3.setOnClickListener {
            if(flag4==1 && edittext.text.toString()!="-0"){
                edittext.text.clear()
            }
            if(flag0==0){
                flag0=2
            }
            if(flag2==0){
                flag2=1
            }
            var help=edittext.text.toString()
            if(help=="-0"){
                edittext.setText("-3")
                flag4=2
            }
            else {
                help+="3"
                edittext.setText(help)
                flag4=2
            }
        }
        button4.setOnClickListener {
            if(flag4==1 && edittext.text.toString()!="-0"){
                edittext.text.clear()
            }
            if(flag0==0){
                flag0=2
            }
            if(flag2==0){
                flag2=1
            }
            var help=edittext.text.toString()
            if(help=="-0"){
                edittext.setText("-4")
                flag4=2
            }
            else {
                help += "4"
                edittext.setText(help)
                flag4 = 2
            }
        }
        button5.setOnClickListener {
            if(flag4==1 && edittext.text.toString()!="-0"){
                edittext.text.clear()
            }
            if(flag0==0){
                flag0=2
            }
            if(flag2==0){
                flag2=1
            }
            var help=edittext.text.toString()
            if(help=="-0"){
                edittext.setText("-5")
                flag4=2
            }
            else {
                help += "5"
                edittext.setText(help)
                flag4 = 2
            }
        }
        /*button5.setOnClickListener {
            if(flag4==1){
                edittext.text.clear()
            }
            if(flag2==0){
                flag2=1
            }
            var help=edittext.text.toString()
            if(help=="-0"){
                edittext.setText("-3")
                flag4=2
            }
            else {
                help += "5"
                edittext.setText(help)
                flag4 = 2
            }
        }*/
        button6.setOnClickListener {
            if(flag4==1 && edittext.text.toString()!="-0"){
                edittext.text.clear()
            }
            if(flag0==0){
                flag0=2
            }
            if(flag2==0){
                flag2=1
            }
            var help=edittext.text.toString()
            if(help=="-0"){
                edittext.setText("-6")
                flag4=2
            }
            else {
                help += "6"
                edittext.setText(help)
                flag4 = 2
            }
        }
        button7.setOnClickListener {
            if(flag4==1 && edittext.text.toString()!="-0"){
                edittext.text.clear()
            }
            if(flag0==0){
                flag0=2
            }
            if(flag2==0){
                flag2=1
            }
            var help=edittext.text.toString()
            if(help=="-0"){
                edittext.setText("-7")
                flag4=2
            }
            else {
                help += "7"
                edittext.setText(help)
                flag4 = 2
            }
        }
        button8.setOnClickListener {
            if(flag4==1 && edittext.text.toString()!="-0"){
                edittext.text.clear()
            }
            if(flag0==0){
                flag0=2
            }
            if(flag2==0){
                flag2=1
            }
            var help=edittext.text.toString()
            if(help=="-0"){
                edittext.setText("-8")
                flag4=2
            }
            else {
                help += "8"
                edittext.setText(help)
                flag4 = 2
            }
        }
        button9.setOnClickListener {
            if(flag4==1 && edittext.text.toString()!="-0"){
                edittext.text.clear()
            }
            if(flag0==0){
                flag0=2
            }
            if(flag2==0){
                flag2=1
            }
            var help=edittext.text.toString()
            if(help=="-0"){
                edittext.setText("-9")
                flag4=2
            }
            else {
                help += "9"
                edittext.setText(help)
                flag4 = 2
            }
        }

        addbutton.setOnClickListener {
            if(!TextUtils.isEmpty(edittext.getText().toString())){
                first=edittext.getText().toString().toDouble()
                opn="+"
                edittext.setText("")
                val helpstr=first.toString()
                if(helpstr.takeLast(2)==".0"){
                    edittext.hint= helpstr.dropLast(2)
                }
                else {
                    edittext.hint = first.toString()
                }
            }
            else if(TextUtils.isEmpty(edittext.getText().toString()) && flag7==1){
                first=edittext.hint.toString().toDouble()
                opn="+"
                edittext.setText("")
                val helpstr=first.toString()
                if(helpstr.takeLast(2)==".0"){
                    edittext.hint= helpstr.dropLast(2)
                    flag7=0
                }
                else {
                    edittext.hint = first.toString()
                    flag7 = 0
                }

            }
        }
        subbutton.setOnClickListener {
            if(!TextUtils.isEmpty(edittext.getText().toString())){
                first=edittext.getText().toString().toDouble()
                opn="-"
                edittext.setText("")
                val helpstr=first.toString()
                if(helpstr.takeLast(2)==".0"){
                    edittext.hint= helpstr.dropLast(2)
                }
                else {
                    edittext.hint = first.toString()
                }
            }
            else if(TextUtils.isEmpty(edittext.getText().toString()) && flag7==1){
                first=edittext.hint.toString().toDouble()
                opn="-"
                edittext.setText("")
                val helpstr=first.toString()
                if(helpstr.takeLast(2)==".0"){
                    edittext.hint= helpstr.dropLast(2)
                    flag7=0
                }
                else {
                    edittext.hint = first.toString()
                    flag7 = 0
                }

            }
            else if(TextUtils.isEmpty(edittext.getText().toString()) && edittext.hint.toString().toDouble()==0.0){
                //flag0=1
                edittext.setText("-")

            }//first -ve
            else if(TextUtils.isEmpty(edittext.getText().toString()) && edittext.hint.toString().toDouble()!=0.0){
                //flag0=1
                edittext.setText("-")

            }//second -ve
        }
        multiplybutton.setOnClickListener {
            if(!TextUtils.isEmpty(edittext.getText().toString())){
                first=edittext.getText().toString().toDouble()
                opn="*"
                edittext.setText("")
                val helpstr=first.toString()
                if(helpstr.takeLast(2)==".0"){
                    edittext.hint= helpstr.dropLast(2)
                }
                else {
                    edittext.hint = first.toString()
                }
            }
            else if(TextUtils.isEmpty(edittext.getText().toString()) && flag7==1){
                first=edittext.hint.toString().toDouble()
                opn="*"
                edittext.setText("")
                val helpstr=first.toString()
                if(helpstr.takeLast(2)==".0"){
                    edittext.hint= helpstr.dropLast(2)
                }
                else {
                    edittext.hint = first.toString()
                }
                flag7=0

            }
        }
        dividebutton.setOnClickListener {
            if(!TextUtils.isEmpty(edittext.getText().toString())){
                first=edittext.getText().toString().toDouble()
                opn="/"
                edittext.setText("")
                val helpstr=first.toString()
                if(helpstr.takeLast(2)==".0"){
                    edittext.hint= helpstr.dropLast(2)
                }
                else {
                    edittext.hint = first.toString()
                }
            }
            else if(TextUtils.isEmpty(edittext.getText().toString()) && flag7==1){
                first=edittext.hint.toString().toDouble()
                opn="/"
                edittext.setText("")
                val helpstr=first.toString()
                if(helpstr.takeLast(2)==".0"){
                    edittext.hint= helpstr.dropLast(2)
                }
                else {
                    edittext.hint = first.toString()
                }
                flag7=0

            }
        }
        equalbutton.setOnClickListener {
            if(!TextUtils.isEmpty(edittext.getText().toString())){
                second=edittext.getText().toString().toDouble()
                if(opn=="+"){
                    ans=first+second
                }
                else if(opn=="-"){
                    ans=first-second
                }
                else if(opn=="*"){
                    ans=first*second
                }
                else if(opn=="/"){
                    ans=first/second
                }
                edittext.setText("")
                val helpstr=ans.toString()
                if(helpstr.takeLast(2)==".0"){
                    edittext.hint= helpstr.dropLast(2)
                }
                else {
                    edittext.hint = ans.toString()
                }
                flag7=1
            }
            else if(flag7==1){
                first=edittext.hint.toString().toDouble()
                //second=first
                if(opn=="+"){
                    ans=first+second
                }
                else if(opn=="-"){
                    ans=first-second
                }
                else if(opn=="*"){
                    ans=first*second
                }
                else if(opn=="/"){
                    ans=first/second
                }
                edittext.setText("")
                val helpstr=ans.toString()
                if(helpstr.takeLast(2)==".0"){
                    edittext.hint= helpstr.dropLast(2)
                }
                else {
                    edittext.hint = ans.toString()
                }
                flag7=1
            }
            else{
                second=first
                if(opn=="+"){
                    ans=first+second
                }
                else if(opn=="-"){
                    ans=first-second
                }
                else if(opn=="*"){
                    ans=first*second
                }
                else if(opn=="/"){
                    ans=first/second
                }
                edittext.setText("")
                val helpstr=ans.toString()
                if(helpstr.takeLast(2)==".0"){
                    edittext.hint= helpstr.dropLast(2)
                }
                else {
                    edittext.hint = ans.toString()
                }
                flag7=1
            }
        }





        /*
            Tests for android can not guarantee the correctness of solutions that make use of
            mutation on "static" variables to keep state. You should avoid using those.
            Consider "static" as being anything on kotlin that is transpiled to java
            into a static variable. That includes global variables and variables inside
            singletons declared with keyword object, including companion object.
            This limitation is related to the use of JUnit on tests. JUnit re-instantiate all
            instance variable for each test method, but it does not re-instantiate static variables.
            The use of static variable to hold state can lead to state from one test to spill over
            to another test and cause unexpected results.

            Using mutation on static variables to keep state
            is considered a bad practice anyway and no measure
            attempting to give support to that pattern will be made.
        */
    }
}