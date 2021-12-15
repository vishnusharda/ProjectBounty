package com.projectbounty.projectbounty.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.projectbounty.projectbounty.Adapters.OnItemClickListner
import com.projectbounty.projectbounty.Adapters.PdfItemAdapter
import com.projectbounty.projectbounty.Models.PdfItemModel
import com.projectbounty.projectbounty.databinding.FragmentProjectBinding

class ProjectFragment : Fragment(), OnItemClickListner {

    private val args: ProjectFragmentArgs by navArgs()
    lateinit var binding: FragmentProjectBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProjectBinding.inflate(inflater, container, false)

//        Safe Args
        val name = args.name

//        Set title name
        binding.titleText.text = name

//        Project RecyclerView

        val pdfItemModelList: ArrayList<PdfItemModel> = ArrayList()
        pdfItemModelList.add(PdfItemModel("", "", "", "", "", "", ""))
        pdfItemModelList.add(PdfItemModel("", "", "", "", "", "", ""))
        pdfItemModelList.add(PdfItemModel("", "", "", "", "", "", ""))
        pdfItemModelList.add(PdfItemModel("", "", "", "", "", "", ""))


        binding.projectRecyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        val pdfItemAdapter =
            PdfItemAdapter(pdfItemModelList, this, this.requireContext())
        binding.projectRecyclerView.adapter = pdfItemAdapter

        return binding.root
    }

    override fun OnClickListner(pdfItemModelList: List<PdfItemModel>, position: Int) {
        val title = pdfItemModelList.get(position).pdfTitle
        val pdfItemModel: PdfItemModel = PdfItemModel("", "", title, "", "", "", "")
        val action = ProjectFragmentDirections.actionProjectFragmentToProductDeatilsFragment(pdfItemModel)
        findNavController().navigate(action)
    }

}