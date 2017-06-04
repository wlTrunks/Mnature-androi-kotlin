package ru.altarix.mnature_androi_kotlin.features.state

import me.ilich.juggler.gui.JugglerFragment
import me.ilich.juggler.states.ContentOnlyState
import me.ilich.juggler.states.VoidParams
import ru.altarix.mnature_androi_kotlin.features.DashBoardFragment

/**
 * Created by Trunks on 23.05.2017.
 */

class DashboardState : ContentOnlyState<VoidParams>(VoidParams.instance()){
    override fun onConvertContent(params: VoidParams, fragment: JugglerFragment?): JugglerFragment {
        return DashBoardFragment.Companion.newInstance()
    }
}