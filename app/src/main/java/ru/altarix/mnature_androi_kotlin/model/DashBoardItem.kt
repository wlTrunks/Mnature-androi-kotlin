package ru.altarix.mnature_androi_kotlin.model

import java.io.Serializable

/**
 * Created by Trunks on 30.05.2017.
 */


class DashBoardItem(val id: Int, val title: String, val res: Int) : Serializable {
    companion object {
        val ID_MY_REQUEST = 0
        val ID_PROFILE = 1
        val ID_NEWS = 2
        val ID_REGIONS_RATING = 3
        val ID_MESSAGES = 4
        val ID_ANALYTICS = 5
    }
}