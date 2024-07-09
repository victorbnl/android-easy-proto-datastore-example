package com.victorbnl.easyprotodatastore

import MainUi
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.victorbnl.easyprotodatastore.ui.theme.EasyProtoDataStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EasyProtoDataStoreTheme {
                MainUi().MainScreen()
            }
        }
    }
}