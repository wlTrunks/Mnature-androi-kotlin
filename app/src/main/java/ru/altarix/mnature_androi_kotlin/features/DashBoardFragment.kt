package ru.altarix.mnature_androi_kotlin.features

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import ru.altarix.mnature_androi_kotlin.R
import ru.altarix.mnature_androi_kotlin.base.BaseFragment
import kotlinx.android.synthetic.main.dashboard_layout.*
import ru.altarix.mnature_androi_kotlin.features.adapter.DashBoardItemCallback
import ru.altarix.mnature_androi_kotlin.features.adapter.DashboardMenuAdapter
import ru.altarix.mnature_androi_kotlin.model.DashBoardItem

/**
 * Created by Trunks on 23.05.2017.
 */


class DashBoardFragment : BaseFragment(), DashBoardItemCallback {
    override fun onSelected(item: DashBoardItem) {

    }

    companion object {
        val ACTION_CREATE_MESSAGE_PRESSED = "ACTION_CREATE_MESSAGE_PRESSED"
        val ACTION_ITEM_SELECTED = "ACTION_ITEM_SELECTED"
        val EXTRA_DASHBOARD_MENU_ITEM = "EXTRA_DASHBOARD_MENU_ITEM"

        fun newInstance(): DashBoardFragment = DashBoardFragment()
    }

    override fun getLauoutId(): Int {
        return R.layout.dashboard_layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDashBoardList()
    }

    private fun setDashBoardList() {
        dash_board_list.setHasFixedSize(true)
        dash_board_list.layoutManager = GridLayoutManager(context, 2)
        dash_board_list.adapter = DashboardMenuAdapter(context, baseApplication!!.getDashboard(), this)
    }
}
