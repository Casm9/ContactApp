package com.casm.contactapp.core.util

import android.content.Context
import android.net.Uri
import java.io.File
import java.io.FileOutputStream

class UriCopier(private val context: Context) {
    fun copyToInternalStorage(uri: Uri, fileName: String): String? {
        val file = File(context.filesDir, fileName)
        return try {
            context.contentResolver.openInputStream(uri)?.use { inputStream ->
                FileOutputStream(file).use { outputStream ->
                    inputStream.copyTo(outputStream)
                }
            }
            file.absolutePath
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
