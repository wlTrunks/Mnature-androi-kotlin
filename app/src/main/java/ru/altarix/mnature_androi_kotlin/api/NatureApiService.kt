package ru.altarix.mnature_androi_kotlin.api

import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST
import ru.altarix.mnature_androi_kotlin.model.AuthResponse
import ru.altarix.mnature_androi_kotlin.model.User

/**
 * Created by Trunks on 02.06.2017.
 */
interface NatureApiService {

    @POST("app-portal/security/signin")
    fun singIn(@Body user: User): Observable<AuthResponse>
}