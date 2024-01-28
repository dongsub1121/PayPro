package com.nicepayment.paypro.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun setArgs(length: Int, value: String, numeric: Boolean): String {
    val buffer = StringBuffer()

    if (numeric) {
        while (buffer.length < length - value.toByteArray(charset("EUC_KR")).size) {
            buffer.append('0')
        }
        buffer.append(value)
    }
    else {
        buffer.append(value)
        while (buffer.length < length - value.toByteArray(charset("EUC_KR")).size) {
            buffer.append(' ')
        }
    }
    return buffer.toString()
}


fun getDate6(): String {
    val currentDateTime = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("yyMMdd")
    return currentDateTime.format(formatter)
}

fun getDate12(): String {
    val currentDateTime = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("yyMMddHHmmSS")
    return currentDateTime.format(formatter)
}

fun getTime6(): String{
    val currentDateTime = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("HHmmSS")
    return currentDateTime.format(formatter)
}