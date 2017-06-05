package ru.altarix.mnature_androi_kotlin.base.network.session

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by wlTrunks on 05.06.2017.
 */
class AddHeaderInterceptor(val auth: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader("Auth-token", auth)
        return chain.proceed(builder.build())
    }
}