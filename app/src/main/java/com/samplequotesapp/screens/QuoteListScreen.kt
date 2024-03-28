package com.samplequotesapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samplequotesapp.R
import com.samplequotesapp.model.Quote

@Composable
fun QuoteListScreen(data: Array<Quote>, onQuoteClick: (quote: Quote) -> Unit) {
    Column() {
        Text(
            text = "Quotes App",
            textAlign = TextAlign.Center,
            fontSize = 32.sp,
            modifier = Modifier
                .padding(0.dp, 24.dp)
                .fillMaxWidth(1f),
            fontFamily = FontFamily(Font(R.font.montserrat_regular))
        )
        QuoteList(data = data, onQuoteClick )
    }

}