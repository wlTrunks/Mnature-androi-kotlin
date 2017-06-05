package ru.altarix.mnature_androi_kotlin

import android.app.Application
import android.content.Context
import ru.altarix.mnature_androi_kotlin.base.network.NetworkManager
import ru.altarix.mnature_androi_kotlin.base.network.session.Session
import ru.altarix.mnature_androi_kotlin.model.DashBoardItem
import java.util.ArrayList

/**
 * Created by Trunks on 30.05.2017.
 */


class NatureApplication : Application() {

    var networkManager: NetworkManager? = null
    var context: Context? = null

    init {
        instance = this
    }

    companion object {
        val result = ArrayList<DashBoardItem>()
        private var instance: NatureApplication? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = NatureApplication.applicationContext()
        NetworkManager.init(context!!,"https://www.priroda-ok.ru:443/",Session.instance(context!!).sssPrefs)
        networkManager = NetworkManager.getInstance()

        initDashBoardItemList()
    }

    protected fun initDashBoardItemList() {
        result.add(DashBoardItem(DashBoardItem.ID_MY_REQUEST, getString(R.string.my_request), R.drawable.ic_my_request_selector))
        result.add(DashBoardItem(DashBoardItem.ID_MESSAGES, getString(R.string.users_messages), R.drawable.ic_messages_selector))
        result.add(DashBoardItem(DashBoardItem.ID_NEWS, getString(R.string.news), R.drawable.ic_news_selector))
        result.add(DashBoardItem(DashBoardItem.ID_REGIONS_RATING, getString(R.string.raiting_regions), R.drawable.ic_rating_selector))
        result.add(DashBoardItem(DashBoardItem.ID_ANALYTICS, getString(R.string.analytics), R.drawable.ic_analytics_selector))
        result.add(DashBoardItem(DashBoardItem.ID_PROFILE, getString(R.string.title_profile), R.drawable.ic_profile_selector))
    }

    fun getDashboard(): List<DashBoardItem> {
        return result
    }
}