package com.example.appnewskotlin.mvp.details_new

import android.content.Context
import com.example.appnewskotlin.data.database.database.DatabaseHelper
import com.example.appnewskotlin.data.database.entity.Item
import org.jetbrains.anko.doAsync
import java.util.*

class DetailsNewsPresenter(var mView: DetailsNewsInterface.View, var context: Context): DetailsNewsInterface.Presenter {



    var model: DetailsNewsInterface.Model = DetailsNewsModel(this, context)


    override fun insertNewsDatabase(news: Item?) {
        model.requestInsertNewsDatabase(news)
    }
    override fun returnInsertNewsDatabase(news: Item?) {
        mView.showResult(news)
    }


    override fun removeNewsDatabase(news: Item?) {
        model.requestRemoveNewsDatabase(news)
    }
    override fun returnRemoveNewsDatabase(news: Item?) {
        mView.showResult(news)
    }
}