package com.example.appnewskotlin.data.model
import java.io.Serializable


class Channel(
    var item: MutableList<Item>? = null): Serializable {
    constructor() : this( null)
}