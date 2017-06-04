package ru.altarix.mnature_androi_kotlin.base.network.session

/**
 * Created by Trunks on 02.06.2017.
 */
interface SessionListener {
    fun getSession(): String?
    fun setSession(session: String?)
    fun hasSession(): Boolean
    fun clear()
}