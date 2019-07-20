package com.example.appnewskotlin.mvp.list_category

import com.example.appnewskotlin.data.model.Category
import com.example.appnewskotlin.data.model.Item


interface ItemClickCategoryListener {
    fun onItemClick(position: Int, category: Category)
}