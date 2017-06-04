package ru.altarix.mnature_androi_kotlin.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Trunks on 02.06.2017.
 */

data class User(@SerializedName("login") val login: String,
                @SerializedName("password") val password: String,
                @SerializedName("longLife") val longLife: Boolean = true)