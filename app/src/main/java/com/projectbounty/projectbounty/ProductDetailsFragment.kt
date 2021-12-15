package com.projectbounty.projectbounty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.projectbounty.projectbounty.databinding.FragmentProductDetailsBinding

class ProductDetailsFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailsBinding
    private val args by navArgs<ProductDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//          Inflate the layout for this fragment
        binding = FragmentProductDetailsBinding.inflate(inflater, container, false)

//        Get Args
        val title = args?.pdfItems.pdfTitle

        return binding.root
    }
}