package com.victorbnl.easyprotodatastore.preferences

data class Preferences(
    val username: String = "",
    val age: Int = 0,
    val notifications: Boolean = false
)