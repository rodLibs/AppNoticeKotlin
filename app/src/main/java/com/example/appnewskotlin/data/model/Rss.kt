package com.example.appnewskotlin.data.model
import java.io.Serializable



class Rss(
    var channel: Channel? = null): Serializable {
    constructor() : this( null)
}



