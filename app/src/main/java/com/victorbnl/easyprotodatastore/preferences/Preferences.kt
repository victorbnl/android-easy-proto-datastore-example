package com.victorbnl.easyprotodatastore.preferences

import kotlinx.serialization.Serializable

@Serializable
data class Preferences(
    val username: String = "",
    val age: Int = 0,
    val notifications: Boolean = false
)