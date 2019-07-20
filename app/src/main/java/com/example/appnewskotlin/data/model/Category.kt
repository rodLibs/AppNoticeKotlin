package com.example.appnewskotlin.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Category(var name: String? = null, var url: String? = null): Parcelable {
}