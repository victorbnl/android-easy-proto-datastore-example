package com.victorbnl.easyprotodatastore.preferences

import androidx.datastore.core.Serializer
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.protobuf.ProtoBuf
import java.io.InputStream
import java.io.OutputStream

@OptIn(ExperimentalSerializationApi::class)
object PreferencesSerializer : Serializer<Preferences> {
    override val defaultValue = Preferences()

    override suspend fun readFrom(input: InputStream): Preferences {
        return try {
            ProtoBuf.decodeFromByteArray(
                Preferences.serializer(),
                input.readBytes()
            )
        } catch (_: Exception) {
            defaultValue
        }
    }

    @Suppress("BlockingMethodInNonBlockingContext")
    override suspend fun writeTo(t: Preferences, output: OutputStream) {
        output.write(ProtoBuf.encodeToByteArray(Preferences.serializer(), t))
    }
}