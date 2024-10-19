package com.example.hpapplicationtp.dtos

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Post(
    val id: String,
    val name: String,
    @Json(name = "alternate_names")
    val alternateNames: List<String>,
    val species: String,
    val gender: String,
    val house: String?,
    @Json(name = "dateOfBirth")
    val dateOfBirth: String?,
    @Json(name = "yearOfBirth")
    val yearOfBirth: Int?,
    val wizard: Boolean,
    val ancestry: String?,
    @Json(name = "eyeColour")
    val eyeColour: String?,
    @Json(name = "hairColour")
    val hairColour: String?,
    val wand: Wand?,
    val patronus: String?,
    @Json(name = "hogwartsStudent")
    val hogwartsStudent: Boolean,
    @Json(name = "hogwartsStaff")
    val hogwartsStaff: Boolean,
    val actor: String?,
    @Json(name = "alternate_actors")
    val alternateActors: List<String>,
    val alive: Boolean,
    val image: String?
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class Wand(
    val wood: String?,
    val core: String?,
    val length: Double?
) : Parcelable
