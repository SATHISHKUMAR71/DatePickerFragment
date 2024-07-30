package com.example.datepickerfragmentcommunication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import com.google.android.material.button.MaterialButton


class HomeFragment : Fragment(),DatePickerListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        view.findViewById<MaterialButton>(R.id.pickDate).setOnClickListener{
            DatePickerFragment().show(parentFragmentManager,"DatePicker")
        }
        return view
    }
    override fun onDateSetListener(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        println("From Fragment: $p1,$p2,$p3")
    }

}