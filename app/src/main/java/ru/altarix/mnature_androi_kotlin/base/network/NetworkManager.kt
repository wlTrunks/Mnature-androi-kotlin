package ru.altarix.mnature_androi_kotlin.base.network

import android.content.Context
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import ru.altarix.mnature_androi_kotlin.base.network.session.SessionListener


/**
 * Created by Trunks on 01.06.2017.
 */

class NetworkManager {

    companion object {
        fun getInstance(): NetworkManager? {
            return Holder.INSTANCE
        }

        fun init(context: Context, url: String, sessionListener: SessionListener) {
            Holder.INSTANCE = NetworkManager(context, url, sessionListener)
        }

        fun <S> httpClient(serviceClass: Class<S>): S {
//            val httpClient = NetworkManager.getInstance()!!.httpClient
            var retrofit = NetworkManager.getInstance()!!.retrofit
//            if (!httpClient.interceptors().contains(NetworkManager.getInstance()!!.logging)) {
//                httpClient.addInterceptor(NetworkManager.getInstance()!!.logging)
//                NetworkManager.getInstance()!!.builder.client(httpClient.build())
//                retrofit = NetworkManager.getInstance()!!.builder.build()
//            }
            return retrofit.create(serviceClass)
        }
    }

    val builder: Retrofit.Builder
    val retrofit: Retrofit
    val httpClient: OkHttpClient.Builder
    val logging: HttpLoggingInterceptor
    var BASE_URL: String? = null
    val sessionListener: SessionListener

    private constructor(context: Context, url: String, sessionListener: SessionListener) {
        BASE_URL = url
        builder = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        retrofit = builder.build()
        httpClient = OkHttpClient.Builder()
        logging = HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
        httpClient.addInterceptor(logging)
        this.sessionListener = sessionListener

    }

    private object Holder {
        var INSTANCE: NetworkManager? = null
    }

}