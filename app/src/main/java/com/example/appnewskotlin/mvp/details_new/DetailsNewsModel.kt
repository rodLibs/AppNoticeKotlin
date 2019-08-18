package com.example.appnewskotlin.mvp.details_new

import android.content.Context
import com.example.appnewskotlin.data.database.database.DatabaseHelper
import com.example.appnewskotlin.data.database.entity.Item
import org.jetbrains.anko.doAsync
import java.util.*

class DetailsNewsModel(var mPresenter: DetailsNewsInterface.Presenter, var context: Context): DetailsNewsInterface.Model {


    var databaseHelper = DatabaseHelper.getInstance(context)


    override fun requestInsertNewsDatabase(news: Item?) {
        doAsync {
            news?.id = Date().time
            databaseHelper?.itemDAO()?.insert(news)
            mPresenter.returnInsertNewsDatabase(news)
        }
    }


    override fun requestRemoveNewsDatabase(news: Item?) {
        doAsync {
            databaseHelper?.itemDAO()?.delete(news)
            news?.id = null
            mPresenter.returnRemoveNewsDatabase(news)
        }
    }
}