package ru.altarix.mnature_androi_kotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by wlTrunks on 05.06.2017.
 */
class AuthResponse(@SerializedName("sessionId")@Expose val sessionId: String,
                   @SerializedName("active")@Expose val active: Boolean)
