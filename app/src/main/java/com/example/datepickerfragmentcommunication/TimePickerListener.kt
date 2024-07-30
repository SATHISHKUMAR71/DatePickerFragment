package com.example.datepickerfragmentcommunication

import android.widget.TimePicker

interface TimePickerListener {
    fun onTimeSetListener(p0: TimePicker?, p1: Int, p2: Int)
}