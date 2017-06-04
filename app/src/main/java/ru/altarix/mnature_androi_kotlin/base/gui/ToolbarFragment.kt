package ru.altarix.mnature_androi_kotlin.base.gui

import android.os.Bundle
import android.support.v7.app.ActionBar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.ilich.juggler.gui.JugglerFragment
import me.ilich.juggler.gui.JugglerToolbarFragment
import ru.altarix.mnature_androi_kotlin.R
/**
 * Created by Trunks on 01.06.2017.
 */


open class ToolbarFragment : JugglerToolbarFragment() {

    override fun getToolbarId(): Int = R.id.toolbar

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_toolbar, container, false)
    }

    companion object {
        fun createBack(): JugglerFragment {
            val fragment = ToolbarFragment()
            val bundle = JugglerToolbarFragment.addDisplayOptionsToBundle(null, ActionBar.DISPLAY_SHOW_TITLE or ActionBar.DISPLAY_HOME_AS_UP)
            fragment.arguments = bundle
            return fragment
        }
    }
}