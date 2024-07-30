package com.example.datepickerfragmentcommunication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TextView
import com.google.android.material.button.MaterialButton

class ScheduleTimeFragment : Fragment() {

    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_schedule_time, container, false)
        val btn = view.findViewById<MaterialButton>(R.id.pickTime)
        textView = view.findViewById<TextView>(R.id.textView)
        textView.text = "Your Scheduled date is ${arguments?.getInt("day")}/${arguments?.getInt("month")}/${arguments?.getInt("year")}"
        view.findViewById<MaterialButton>(R.id.pickTime).setOnClickListener{
            TimePickerFragment().show(parentFragmentManager,"TimePicker")
        }
        if(arguments?.getInt("hour")==0 && arguments?.getInt("minute")==0){
            textView.text = "Your Scheduled date is ${arguments?.getInt("day")}/${arguments?.getInt("month")}/${arguments?.getInt("year")}"
        }
        else{
            btn.text = "Change Time"
            textView.text ="Meeting Date and Time is ${arguments?.getInt("day")}/" +
            "${arguments?.getInt("month")}/${arguments?.getInt("year")} at ${arguments?.getInt("hour")}:${if(arguments?.getInt("minute")==0)"00" else(arguments?.getInt("minute"))}"

        }
        btn.setOnClickListener{
            TimePickerFragment().show(parentFragmentManager,"TimePicker")
        }
        return view
    }



}