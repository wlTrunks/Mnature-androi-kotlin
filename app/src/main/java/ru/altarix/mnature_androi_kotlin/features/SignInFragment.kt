package ru.altarix.mnature_androi_kotlin.features

import android.os.Bundle
import android.view.View
import ru.altarix.mnature_androi_kotlin.R
import ru.altarix.mnature_androi_kotlin.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_sign_in.*

/**
 * Created by Trunks on 01.06.2017.
 */

class SignInFragment : BaseFragment() {

    companion object {
        fun newInstance(): SignInFragment = SignInFragment()
    }

    override fun getLauoutId(): Int = R.layout.fragment_sign_in

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        signIn.setOnClickListener { sing() }
    }

    fun sing() {
    }
}

