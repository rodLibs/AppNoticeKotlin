package com.example.appnewskotlin.mvp.list_category

import com.example.appnewskotlin.data.pojo.Category
import com.example.appnewskotlin.util.Constants


class ListCategoryModel(var mPresenter: ListCategoryInterface.Presenter):ListCategoryInterface.Model {


    override fun listCategory() {
        val listCategory = ArrayList<Category>()
        listCategory.add(Category("FAVORITAS", Constants.FAVORITE))
        listCategory.add(Category("TODAS", Constants.QUERY_NEWS_ALL))
        listCategory.add(Category("MUNDO", Constants.QUERY_NEWS_WORLD))
        listCategory.add(Category("BRASIL", Constants.QUERY_NEWS_BRAZIL))
        listCategory.add(Category("CARROS", Constants.QUERY_NEWS_CARS))
        listCategory.add(Category("CIÊNCIA E SAÚDE", Constants.QUERY_NEWS_SCIENCE_HEALTH))
        listCategory.add(Category("ECONOMIA", Constants.QUERY_NEWS_ECONOMY))
        listCategory.add(Category("EDUCAÇÃO", Constants.QUERY_NEWS_EDUCATION))
        listCategory.add(Category("NATUREZA", Constants.QUERY_NEWS_NATURE))
        listCategory.add(Category("POLITICA", Constants.QUERY_NEWS_POLITICALLY))
        listCategory.add(Category("TECNOLOGIA", Constants.QUERY_NEWS_TECH))
        listCategory.add(Category("TURISMO", Constants.QUERY_NEWS_TOURISM))
        mPresenter.returnListCategory(listCategory)
    }
}