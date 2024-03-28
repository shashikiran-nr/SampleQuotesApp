package com.samplequotesapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.samplequotesapp.model.Quote

@Composable
fun QuoteList(data: Array<Quote>, onQuoteClick: (quote: Quote) -> Unit) {
    LazyColumn(content = {
        items(data){
            QuoteListItem(quote = it, onQuoteClick)
        }
    })
}