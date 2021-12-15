package com.projectbounty.projectbounty.Models

import android.os.Parcelable
import androidx.navigation.NavArgs
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PdfItemModel(
    val pdfImages: String,
    val pdf: String,
    val pdfTitle: String,
    val pdfDesc: String,
    val PdfId: String,
    val pdfMrp: String,
    val pdfPrice: String
) : Parcelable