package com.example.datepickerfragmentcommunication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.button.MaterialButton


class SuccessFragment : Fragment() {


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_success, container, false)
        view.findViewById<TextView>(R.id.successTextView).text ="Meeting is Scheduled Successfully on ${arguments?.getInt("day")}/" +
                "${arguments?.getInt("month")}/${arguments?.getInt("year")} at ${arguments?.getInt("hour")}:${if(arguments?.getInt("minute")==0)"00" else(arguments?.getInt("minute"))} Thank you "
        view.findViewById<MaterialButton>(R.id.changeDate).setOnClickListener {
            DatePickerFragment().show(parentFragmentManager,"change Date")
        }
        return view
    }


}