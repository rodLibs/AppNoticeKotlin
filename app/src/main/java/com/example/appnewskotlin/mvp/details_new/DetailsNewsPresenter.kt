package com.example.appnewskotlin.mvp.details_new

import android.content.Context
import com.example.appnewskotlin.data.database.DatabaseHelper
import com.example.appnewskotlin.data.model.Item
import org.jetbrains.anko.doAsync
import java.util.*

class DetailsNewsPresenter(var mView: DetailsNewsInterface.View, var context: Context): DetailsNewsInterface.Presenter {



    var databaseHelper = DatabaseHelper.getInstance(context)



    override fun insertNewsDatabase(news: Item?) {
        doAsync {
            news?.id = Date().time
            databaseHelper?.itemDAO()?.insert(news)
            mView.showResult(news)
        }
    }


    override fun removeNewsDatabase(news: Item?) {
        doAsync {
            databaseHelper?.itemDAO()?.delete(news)
            news?.id = null
            mView.showResult(news)
        }
    }
}