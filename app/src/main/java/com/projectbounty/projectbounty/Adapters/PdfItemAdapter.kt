package com.projectbounty.projectbounty.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.projectbounty.projectbounty.Models.PdfItemModel
import com.projectbounty.projectbounty.R

class PdfItemAdapter(
    val pdfItemModelList: List<PdfItemModel>,
    val listner: OnItemClickListner,
    val context: Context
) : RecyclerView.Adapter<PdfViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PdfViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.project_items, parent, false)
        return PdfViewHolder(view)
    }

    override fun onBindViewHolder(holder: PdfViewHolder, position: Int) {
        holder.pdfCardView.setOnClickListener { listner.OnClickListner(pdfItemModelList, position) }

    }

    override fun getItemCount(): Int {
        return pdfItemModelList.size

    }
}

class PdfViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val pdfCardView = itemView.findViewById<MaterialCardView>(R.id.pdfCardView)
    val pdfTitle = itemView.findViewById<TextView>(R.id.pdfTitle)

}

interface OnItemClickListner {
    fun OnClickListner(pdfItemModelList: List<PdfItemModel>, position: Int)
}
