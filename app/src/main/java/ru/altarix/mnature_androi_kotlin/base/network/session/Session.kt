package ru.altarix.mnature_androi_kotlin.base.network.session

import android.content.Context

/**
 * Created by Trunks on 04.06.2017.
 */
class Session private constructor(val context: Context) {


    val sssPrefs: SessionStorageSharedPrefs = SessionStorageSharedPrefs(context)

    companion object {
        private var INSTANCE: Session? = null

        fun instance(context: Context): Session {
            if (INSTANCE == null) {
                INSTANCE = Session(context)
            }
            return INSTANCE as Session
        }

        fun getSession(): SessionStorageSharedPrefs {
            return INSTANCE!!.sssPrefs
        }
    }
}