package com.example.appnewskotlin.mvp.list_category

import com.example.appnewskotlin.data.pojo.Category


interface ItemClickCategoryListener {
    fun onItemClick(position: Int, category: Category)
}