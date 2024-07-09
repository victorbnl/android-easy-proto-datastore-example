package com.victorbnl.easyprotodatastore

import PreferencesUi
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.victorbnl.easyprotodatastore.ui.theme.EasyProtoDataStoreTheme
import com.victorbnl.easyprotodatastore.viewmodels.PreferencesViewModel

class PreferencesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: PreferencesViewModel by viewModels()
        enableEdgeToEdge()
        setContent {
            EasyProtoDataStoreTheme {
                PreferencesUi(viewModel).MainScreen()
            }
        }
    }
}