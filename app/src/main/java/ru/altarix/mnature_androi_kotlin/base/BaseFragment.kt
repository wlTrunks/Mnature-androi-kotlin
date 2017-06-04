package ru.altarix.mnature_androi_kotlin.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.ilich.juggler.gui.JugglerFragment
import ru.altarix.mnature_androi_kotlin.NatureApplication
import ru.altarix.mnature_androi_kotlin.base.network.NetworkManager

/**
 * Created by Trunks on 28.05.2017.
 */

open class BaseFragment : JugglerFragment() {
    open fun getLauoutId(): Int = -1
    protected var baseApplication: NatureApplication? = NatureApplication()
    val networkManager: NetworkManager = NetworkManager.getInstance()!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLauoutId(), container, false)
    }
}