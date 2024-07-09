package com.victorbnl.easyprotodatastore.viewmodels

import androidx.datastore.core.DataStore
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.victorbnl.easyprotodatastore.preferences.Preferences
import kotlinx.coroutines.launch

class PreferencesViewModel(
    private val prefStore: DataStore<Preferences>
) : ViewModel() {
    val preferences = MutableLiveData<Preferences>()

    init {
        load()
    }

    fun save() {
        viewModelScope.launch {
            prefStore.updateData {
                preferences.value!!
            }
        }
    }

    fun load() {
        viewModelScope.launch {
            prefStore.data.collect {
                preferences.postValue(it)
            }
        }
    }

    companion object {
        val Factory = { prefStore: DataStore<Preferences> ->
            viewModelFactory {
                initializer {
                    PreferencesViewModel(prefStore)
                }
            }
        }
    }
}