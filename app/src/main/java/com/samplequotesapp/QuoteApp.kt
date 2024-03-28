package com.samplequotesapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.samplequotesapp.model.DataManager
import com.samplequotesapp.screens.QuoteDetail
import com.samplequotesapp.screens.QuoteListScreen
import com.samplequotesapp.utils.Pages

@Composable
fun QuoteApp() {
    if (DataManager.isDataLoaded) {
        if(DataManager.currentPage == Pages.LISTING) {
            QuoteListScreen(data = DataManager.data) {
                DataManager.switchPages(it)
            }
        }else{
            DataManager.currentQuote?.let { QuoteDetail(quote = it) }
        }
    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)
        ) {
            Text(
                text = "Loading...",
                color = Color.Black,
                fontSize = 48.sp,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}