package com.example.datepickerfragmentcommunication

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity(),TimePickerListener,DatePickerListener {
    val dataBundle = Bundle()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onTimeSetListener(p0: TimePicker?, p1: Int, p2: Int) {
        println("From Activity : Selected Time:$p1:$p2")

        with(dataBundle){
            putInt("hour",p1)
            putInt("minute",p2)
        }
        val successFragment = SuccessFragment()
        successFragment.arguments = dataBundle
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView2,successFragment)
            .commit()
    }

    override fun onDateSetListener(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        val scheduleTimeFragment = ScheduleTimeFragment()
        with(dataBundle){
            putInt("year",p1)
            putInt("month",p2)
            putInt("day",p3)
        }
        scheduleTimeFragment.arguments = dataBundle
        println("Year: $p1 month: $p2 day: $p3")
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView2,scheduleTimeFragment)
            .commit()
    }

}