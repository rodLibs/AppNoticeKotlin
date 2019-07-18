package com.example.appnewskotlin.data.model
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
@Entity(tableName = "item", primaryKeys = ["itemId"])
class Item (

    @ColumnInfo(name = "itemId")
    var id: Long? = null,

    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name = "link")
    var link: String? = null,

    @ColumnInfo(name = "description")
    var description: String? = null,

    @ColumnInfo(name = "category")
    var category: String? = null,

    @ColumnInfo(name = "date")
    var pubDate: String? = null): Parcelable {


    constructor() : this( null, null,null,null,null, null)
}