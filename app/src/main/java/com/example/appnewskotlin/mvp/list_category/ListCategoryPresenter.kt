package com.example.appnewskotlin.mvp.list_category

import android.content.Context
import com.example.appnewskotlin.data.pojo.Category
import com.example.appnewskotlin.util.Constants


class ListCategoryPresenter(var mView: ListCategoryInterface.View, var context: Context): ListCategoryInterface.Presenter {


    var model: ListCategoryInterface.Model = ListCategoryModel(this)



    override fun getListCategory() {
        model.listCategory()
    }

    override fun returnListCategory(listCategory: ArrayList<Category>) {
        mView.showListCategory(listCategory)
    }
}