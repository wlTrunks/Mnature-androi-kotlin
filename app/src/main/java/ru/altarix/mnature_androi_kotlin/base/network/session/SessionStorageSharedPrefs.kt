package ru.altarix.mnature_androi_kotlin.base.network.session

import android.content.Context

/**
 * Created by Trunks on 04.06.2017.
 */

class SessionStorageSharedPrefs(val contex: Context) : SessionListener {

    val PREFS = "session_storage_prefs"
    val SESSION = "session"
    override fun getSession(): String? {
        val prefs = contex.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        return prefs.getString(SESSION, "")
    }

    override fun setSession(session: String?) {
        val prefs = contex.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        prefs.edit().putString(SESSION, session).apply()
    }

    override fun hasSession(): Boolean {
        return !getSession().isNullOrEmpty()
    }

    override fun clear() {
        val prefs = contex.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        prefs.edit().clear().apply()
    }
}