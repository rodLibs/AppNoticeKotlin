package com.example.appnewskotlin.data.pojo
import com.example.appnewskotlin.data.database.entity.Item


class Channel(
    var item: MutableList<Item>? = null) {
    constructor() : this( null)
}