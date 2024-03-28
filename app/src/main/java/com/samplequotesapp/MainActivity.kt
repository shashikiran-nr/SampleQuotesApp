package com.samplequotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.samplequotesapp.model.DataManager
import com.samplequotesapp.ui.theme.SampleQuotesAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Using a coroutine scope to fetch the quotes data in background
        CoroutineScope(Dispatchers.IO).launch {
            // Adding the delay of 5sec to show the Loading text
            delay(2000)
            DataManager.loadAssetFromFile(applicationContext)
        }
        setContent {
            SampleQuotesAppTheme {
                QuoteApp()
            }
        }
    }
}

