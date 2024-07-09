package com.victorbnl.easyprotodatastore.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.victorbnl.easyprotodatastore.preferences.Preferences

class PreferencesViewModel : ViewModel() {
    val preferences = MutableLiveData<Preferences>(Preferences())
}