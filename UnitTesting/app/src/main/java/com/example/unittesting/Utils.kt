package com.example.unittesting

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

class Utils {
    @SuppressLint("SimpleDateFormat")
    fun toSimpleString(date: Date): String {
        return SimpleDateFormat("EEE, dd MMM yyy").format(date)
    }
}