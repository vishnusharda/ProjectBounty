package com.projectbounty.projectbounty.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.projectbounty.projectbounty.Adapters.SubjectItemAdapter
import com.projectbounty.projectbounty.Models.SubjectItemModel
import com.projectbounty.projectbounty.R

class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search, container, false)

//        Find View By Ids
        val subjectChipRecyclerView: RecyclerView = view.findViewById(R.id.subjectChipRecyclerView)

        val subjectItemModelList: ArrayList<SubjectItemModel> = ArrayList()
        subjectItemModelList.add(
            SubjectItemModel(
                "Mathematics",
                "https://image.freepik.com/free-vector/formula-concept-illustration_114360-7816.jpg",
                "https://cdn-icons-png.flaticon.com/512/2891/2891466.png",
                3
            )
        )
        subjectItemModelList.add(
            SubjectItemModel(
                "Physics",
                "https://image.freepik.com/free-vector/colorful-design-science-education_23-2148484343.jpg",
                "https://cdn-icons.flaticon.com/png/512/2721/premium/2721792.png?token=exp=1638606885~hmac=7c6cf4e4fd3f7de64c35e96c888f2ce6",
                3
            )
        )
        subjectItemModelList.add(
            SubjectItemModel(
                "Accounts",
                "https://image.freepik.com/free-vector/money-income-attraction_74855-6573.jpg",
                "https://cdn-icons.flaticon.com/png/512/4621/premium/4621844.png?token=exp=1638612186~hmac=4c1de1e8ebaaca5f292cf9af4ad642d0",
                3
            )
        )
        subjectItemModelList.add(
            SubjectItemModel(
                "Business Studies",
                "https://image.freepik.com/free-vector/illustration-financial-concept_53876-20606.jpg",
                "https://cdn-icons-png.flaticon.com/512/6340/6340975.png",
                3
            )
        )


        val layoutManager =
            GridLayoutManager(this.requireContext(), 2, LinearLayoutManager.VERTICAL, true)
        subjectChipRecyclerView.layoutManager = layoutManager
        val subjectAdapter =
            SubjectItemAdapter(subjectItemModelList, this.requireContext(), null, false)
        subjectChipRecyclerView.adapter = subjectAdapter

//        Back

        return view
    }

}