package ru.altarix.mnature_androi_kotlin.base

import me.ilich.juggler.gui.JugglerActivity

/**
 * Created by Trunks on 23.05.2017.
 */

abstract class BaseActivity : JugglerActivity() {

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
