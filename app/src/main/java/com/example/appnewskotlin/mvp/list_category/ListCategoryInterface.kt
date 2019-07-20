package com.example.appnewskotlin.mvp.list_category

import com.example.appnewskotlin.data.model.Category

interface ListCategoryInterface {

    interface Presenter{
        fun getListCategory()
    }

    interface View{
        fun showListCategory(listCategory: ArrayList<Category>)
    }
}