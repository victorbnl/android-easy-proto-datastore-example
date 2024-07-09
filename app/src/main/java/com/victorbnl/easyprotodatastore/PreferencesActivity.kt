package com.victorbnl.easyprotodatastore

import PreferencesUi
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.victorbnl.easyprotodatastore.ui.theme.EasyProtoDataStoreTheme

class PreferencesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EasyProtoDataStoreTheme {
                PreferencesUi().MainScreen()
            }
        }
    }
}