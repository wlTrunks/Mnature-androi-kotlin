package ru.altarix.mnature_androi_kotlin.features

import android.os.Bundle
import android.view.View
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.altarix.mnature_androi_kotlin.R
import ru.altarix.mnature_androi_kotlin.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_sign_in.*
import kotlinx.android.synthetic.main.login_layout.*
import ru.altarix.mnature_androi_kotlin.api.NatureApiService
import ru.altarix.mnature_androi_kotlin.base.network.NetworkManager
import ru.altarix.mnature_androi_kotlin.model.AuthResponse
import ru.altarix.mnature_androi_kotlin.model.User
import io.reactivex.disposables.CompositeDisposable


/**
 * Created by Trunks on 01.06.2017.
 */

class SignInFragment : BaseFragment() {

    var compositeDisposable = CompositeDisposable()
    var retrofit: NatureApiService? = null

    companion object {
        fun newInstance(): SignInFragment = SignInFragment()
    }

    override fun getLauoutId(): Int = R.layout.fragment_sign_in
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retrofit = NetworkManager.httpClient(NatureApiService::class.java)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        signIn.setOnClickListener { sing() }
    }

    fun sing() {
        val user = User(login.getText(), password.getText())

        var oauth: Observable<AuthResponse> = retrofit!!.singIn(user).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())


        oauth.subscribe({ response -> getresponse(response) },
                { t: Throwable -> t.printStackTrace() }, { println("OnComplete") })


    }

    fun getresponse(response: AuthResponse) {
        println(response.sessionId)
        println(response.active)
    }
}

