package com.projectbounty.projectbounty.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.card.MaterialCardView
import com.projectbounty.projectbounty.Models.SubjectItemModel
import com.projectbounty.projectbounty.R

class SubjectItemAdapter(
    private var subjectItemModelList: List<SubjectItemModel>,
    val context: Context,
    val listner: ItemClickListner?,
    val isTrue: Boolean
) :
    RecyclerView.Adapter<SubjectViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        if (isTrue == true) {
            val view =
                LayoutInflater.from(context).inflate(R.layout.subjects_items, parent, false)
            return SubjectViewHolder(view)
        } else {
            val view =
                LayoutInflater.from(context).inflate(R.layout.subjects_chips_items, parent, false)
            return SubjectViewHolder(view)
        }

    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        if (isTrue == false) {
            val subjectItemModel: SubjectItemModel = subjectItemModelList.get(position)
            val name = subjectItemModel.subjectName
            val icon = subjectItemModel.subjectIcon
            Glide.with(context)
                .load(icon)
                .into(holder.subjectIcon)
            holder.subjectChipName.setText(name)
        } else {
            val subjectItemModel: SubjectItemModel = subjectItemModelList.get(position)
            val name = subjectItemModel.subjectName
            val totalPdf = subjectItemModel.subjectTotalPdf
            val image = subjectItemModel.subjectImage
            Glide.with(context)
                .load(image)
                .into(holder.subjectImage)

            holder.subjectName.setText(name)
            holder.subjectTotalPdf.setText(totalPdf.toString() + " Project")
            holder.subjectCardView.setOnClickListener { listner!!.onClickListner(subjectItemModelList, position) }
        }


    }

    override fun getItemCount(): Int {
        return subjectItemModelList.size
    }
}

class SubjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val subjectImage = itemView.findViewById<ImageView>(R.id.subjectImage)
    val subjectName = itemView.findViewById<TextView>(R.id.subjectName)
    val subjectTotalPdf = itemView.findViewById<TextView>(R.id.subjectTotalPdf)
    val subjectIcon = itemView.findViewById<ImageView>(R.id.subjectIcon)
    val subjectChipName = itemView.findViewById<TextView>(R.id.subjectChipName)
    val subjectCardView = itemView.findViewById<MaterialCardView>(R.id.subjectCardView)
}

interface ItemClickListner {
    fun onClickListner(subjectItemModelList: List<SubjectItemModel>, positon: Int)
}