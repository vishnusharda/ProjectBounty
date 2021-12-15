package com.projectbounty.projectbounty.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.card.MaterialCardView
import com.projectbounty.projectbounty.Adapters.ItemClickListner
import com.projectbounty.projectbounty.Adapters.SubjectItemAdapter
import com.projectbounty.projectbounty.Models.SubjectItemModel
import com.projectbounty.projectbounty.R


class HomeFragment : Fragment(), ItemClickListner {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

//        Find View By Ids
        val subjectRecyclerView = view.findViewById<RecyclerView>(R.id.subjectsRecyclerView)
        val userImage = view.findViewById<ImageView>(R.id.userImage)
        val downloadBtn = view.findViewById<MaterialCardView>(R.id.downloadedBtn)
        val importantBtn = view.findViewById<MaterialCardView>(R.id.importantBtn)

        Glide.with(this)
            .load("https://cdn-icons-png.flaticon.com/512/4825/4825015.png")
            .circleCrop()
            .into(userImage)

        val subjectItemModelList: ArrayList<SubjectItemModel> = ArrayList()
//        subjectItemModelList.add(
//            SubjectItemModel(
//                "Accountancy",
//                "https://image.freepik.com/free-vector/money-income-attraction_74855-6573.jpg",
//                "",
//                3
//            )
//        )
//        subjectItemModelList.add(
//            SubjectItemModel(
//                "Economics",
//                "https://image.freepik.com/free-vector/flat-illustration-employee-working-office-workplace-searching-data-success-thinking-new-problem-solving-business-theme_1150-41794.jpg",
//                "",
//                3
//            )
//        )
//        subjectItemModelList.add(
//            SubjectItemModel(
//                "Business Studies",
//                "https://image.freepik.com/free-vector/two-business-partners-handshaking_74855-6685.jpg",
//                "",
//                3
//            )
//        )

        subjectItemModelList.add(
            SubjectItemModel(
                "Accountancy",
                "https://cdn-icons-png.flaticon.com/512/6133/6133146.png",
                "",
                3
            )
        )
        subjectItemModelList.add(
            SubjectItemModel(
                "Economics",
                "https://cdn-icons-png.flaticon.com/512/3314/3314400.png",
                "",
                3
            )
        )
        subjectItemModelList.add(
            SubjectItemModel(
                "Business Studies",
                "https://cdn-icons-png.flaticon.com/512/3657/3657020.png",
                "",
                3
            )
        )


        subjectRecyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        val subjectAdapter =
            SubjectItemAdapter(subjectItemModelList, this.requireContext(), this, true)
        subjectRecyclerView.adapter = subjectAdapter


//        Download Btn
        downloadBtn.setOnClickListener() {
            Navigation.findNavController(view)
                .navigate(R.id.action_homeFragment_to_downloadedMaterialFragment)
        }

//        Important Btn
        importantBtn.setOnClickListener() {
            Navigation.findNavController(view)
                .navigate(R.id.action_homeFragment_to_importantMaterialFragment)
        }

        return view
    }

    override fun onClickListner(subjectItemModelList: List<SubjectItemModel>, position: Int) {
        val subjectItemModel = subjectItemModelList.get(position)

        val action = HomeFragmentDirections.actionHomeFragmentToProjectFragment(subjectItemModel.subjectName)
        Navigation.findNavController(requireView()).navigate(action)


    }

}
