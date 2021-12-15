package com.projectbounty.projectbounty.Fragments

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.projectbounty.projectbounty.R

class BottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var updatingImage: ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bottom_sheet, container, false)

//        init view
        updatingImage = view.findViewById(R.id.updatingImg)
        animateImage()
        return view
    }

    private fun animateImage() {
        val rotate = AnimationUtils.loadAnimation(context, R.anim.rotate_animation)
        updatingImage.animation = rotate


        Handler().postDelayed(Runnable {
            updatingImage.clearAnimation()
        }, 5000)
    }

    override fun getTheme(): Int {
        return R.style.CustomBottomSheetDialog
    }
}