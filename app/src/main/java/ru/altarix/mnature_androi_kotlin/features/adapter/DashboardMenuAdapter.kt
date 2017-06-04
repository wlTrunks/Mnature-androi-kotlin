package ru.altarix.mnature_androi_kotlin.features.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.altarix.mnature_androi_kotlin.R
import ru.altarix.mnature_androi_kotlin.model.DashBoardItem
import kotlinx.android.synthetic.main.dashboard_item.view.*

/**
 * Created by Trunks on 29.05.2017.
 */


class DashboardMenuAdapter(context: Context, list: List<DashBoardItem>, callback: DashBoardItemCallback) : RecyclerView.Adapter<DashboardHolder>() {

    private var context: Context? = context
    private var list: ArrayList<DashBoardItem> = list as ArrayList<DashBoardItem>
    private var callback: DashBoardItemCallback = callback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dashboard_item, parent, false)
        return DashboardHolder(view, callback)
    }

    override fun onBindViewHolder(holder: DashboardHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


}

class DashboardHolder(itemView: View, callback: DashBoardItemCallback) : RecyclerView.ViewHolder(itemView) {
    val callBack: DashBoardItemCallback = callback
    fun bind(dashboardItem: DashBoardItem) {
        with(dashboardItem) {
            itemView.title.text = dashboardItem.title
            itemView.image.setImageResource(res)
            itemView.image.setOnClickListener { callBack.onSelected(this) }
        }
    }
}

interface DashBoardItemCallback {
    fun onSelected(item: DashBoardItem)
}