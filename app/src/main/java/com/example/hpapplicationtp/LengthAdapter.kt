package com.example.hpapplicationtp

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

class LengthAdapter {
    @FromJson
    fun fromJson(length: Double?): Double? = length

    @FromJson
    fun fromJson(length: Int?): Double? = length?.toDouble()

    @ToJson
    fun toJson(length: Double?): Double? = length
}
