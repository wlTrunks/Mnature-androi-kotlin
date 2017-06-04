package ru.altarix.mnature_androi_kotlin.features.state

import android.content.Context
import me.ilich.juggler.gui.JugglerFragment
import me.ilich.juggler.states.ContentBelowToolbarState
import me.ilich.juggler.states.VoidParams
import ru.altarix.mnature_androi_kotlin.R
import ru.altarix.mnature_androi_kotlin.base.gui.ToolbarFragment
import ru.altarix.mnature_androi_kotlin.features.SignInFragment

/**
 * Created by Trunks on 01.06.2017.
 */


class SignInState : ContentBelowToolbarState<VoidParams>(VoidParams.instance()) {

    override fun onConvertContent(params: VoidParams, fragment: JugglerFragment?): JugglerFragment {
        return SignInFragment.newInstance()
    }

    override fun onConvertToolbar(params: VoidParams, fragment: JugglerFragment?): JugglerFragment {
        return ToolbarFragment.createBack()
    }


    override fun getTitle(context: Context?, params: VoidParams?): String? {
        return context!!.getString(R.string.sign_in_title)
    }
}
