package com.samplequotesapp.model

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.google.gson.Gson
import com.samplequotesapp.utils.Pages

object DataManager {

    var data = emptyArray<Quote>()
    var isDataLoaded by mutableStateOf(false)
    var currentPage by mutableStateOf(Pages.LISTING)
    var currentQuote: Quote? = null

    fun loadAssetFromFile(context: Context) {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        isDataLoaded = true
    }

    fun switchPages(quote: Quote?) {
        if(currentPage == Pages.LISTING) {
            currentQuote = quote
            currentPage = Pages.DETAIL
        } else {
            currentPage = Pages.LISTING
        }
    }
}

