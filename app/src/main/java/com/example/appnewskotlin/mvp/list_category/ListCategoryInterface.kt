package com.example.appnewskotlin.mvp.list_category

import com.example.appnewskotlin.data.pojo.Category

interface ListCategoryInterface {

    interface Presenter{
        fun getListCategory()
        fun returnListCategory(listCategory: ArrayList<Category>)
    }

    interface View{
        fun showListCategory(listCategory: ArrayList<Category>)
    }

    interface Model{
        fun listCategory()
    }
}