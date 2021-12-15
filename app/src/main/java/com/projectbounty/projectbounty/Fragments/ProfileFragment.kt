package com.projectbounty.projectbounty.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.projectbounty.projectbounty.R
import com.projectbounty.projectbounty.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        val classes = resources.getStringArray(R.array.classes)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_class_item, classes)
        binding.classAutoTextView.setAdapter(arrayAdapter)

        return binding.root
    }
}