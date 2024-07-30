package com.example.datepickerfragmentcommunication

import android.app.Dialog
import android.app.TimePickerDialog
import android.icu.text.DateFormat
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class TimePickerFragment : DialogFragment(),TimePickerDialog.OnTimeSetListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time_picker, container, false)
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val calendar =Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        return TimePickerDialog(requireActivity(),this,hour,minute,false)

    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
//        var format = ""
//        var hour = 12
//        if(p1 < 12){
//            format = "AM"
//            hour = p1
//        }
//        else{
//            format = "PM"
//            hour = if(p1 == 12){
//                12
//            } else{
//                p1-12
//            }
//        }
        (activity as? TimePickerListener)?.onTimeSetListener(p0,p1,p2)
        Toast.makeText(context," You Meeting Scheduled on: $p1:$p2 Successfully",Toast.LENGTH_LONG).show()
    }

}