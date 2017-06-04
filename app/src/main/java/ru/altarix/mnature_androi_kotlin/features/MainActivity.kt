package ru.altarix.mnature_androi_kotlin.features

import me.ilich.juggler.states.State
import ru.altarix.mnature_androi_kotlin.base.BaseActivity
import ru.altarix.mnature_androi_kotlin.features.state.DashboardState
import ru.altarix.mnature_androi_kotlin.features.state.SignInState

/**
 * Created by Trunks on 28.05.2017.
 */
class MainActivity : BaseActivity() {

    override fun createState(): State<*> {
        return SignInState()
    }
}