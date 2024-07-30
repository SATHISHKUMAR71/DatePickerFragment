package com.example.datepickerfragmentcommunication

import android.widget.DatePicker

interface DatePickerListener {
    fun onDateSetListener(p0: DatePicker?, p1: Int, p2: Int, p3: Int)
}